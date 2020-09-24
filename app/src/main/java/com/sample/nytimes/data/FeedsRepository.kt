package com.sample.nytimes.data

import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.data.sources.FeedsRemoteSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * this repository is responsible to manage data transactions related feed
 * [remoteDataSource] network datasource for feeds
 */
class FeedsRepository(
    private val remoteDataSource: FeedsRemoteSource
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

}