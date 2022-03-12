package com.sample.nytimes.data

import com.sample.nytimes.NyTimesApp
import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.data.beans.FeedCommentPost
import com.sample.nytimes.data.beans.response.FeedCommentResponse
import com.sample.nytimes.data.sources.FeedsRemoteSource
import com.sample.nytimes.data.sources.FeedsLocalSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*
import kotlin.collections.ArrayList

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * this repository is responsible to manage data transactions related feed
 * [remoteDataSource] network datasource for feeds
 */
class FeedsRepository(
    private val remoteDataSource: FeedsRemoteSource,
    private val localDataSource: FeedsLocalSource
) : IFeedsRepository {

    /**
     * this method is responsible to perform a network call to get latest feeds from NYT's server
     * [page] can be used to manage pagination
     */
    override fun queryFeedsByPage(page: Int): Flow<ArrayList<Feed>> = flow {
        remoteDataSource.queryFeedsByPage(page).also {
            it.results?.let { results -> emit(results) }
        }
    }

    override fun postComments(message: String, date: Date): Flow<FeedCommentResponse> = flow {
        localDataSource.postComment(FeedCommentPost(0, "", message, date))

        if (NyTimesApp.INSTANCE.isNetworkAvailable.value != false)
            remoteDataSource.postComments(localDataSource.getSavedComments())
    }

    override fun syncComments(): Flow<FeedCommentResponse> = flow {
        remoteDataSource.postComments(localDataSource.getSavedComments())
    }
}