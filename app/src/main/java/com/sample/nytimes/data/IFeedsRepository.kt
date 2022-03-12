package com.sample.nytimes.data

import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.data.beans.FeedCommentPost
import com.sample.nytimes.data.beans.response.FeedCommentResponse
import com.sample.nytimes.data.beans.response.FeedResponse
import com.sample.nytimes.utils.ApiConstants
import com.sample.nytimes.utils.Callback
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.*
import kotlin.collections.ArrayList

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * interface for feeds repository implementation
 */
interface IFeedsRepository {

    /**
     * this method is responsible to perform a network call to get latest feeds from NYT's server
     * [page] can be used to manage pagination
     * [callback] will be used to return data set on receive from server
     */
    fun queryFeedsByPage(page: Int): Flow<ArrayList<Feed>>

    fun postComments(message: String, date: Date): Flow<FeedCommentResponse>

    fun syncComments(): Flow<FeedCommentResponse>
}