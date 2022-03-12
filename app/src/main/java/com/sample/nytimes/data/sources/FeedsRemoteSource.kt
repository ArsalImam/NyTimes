package com.sample.nytimes.data.sources

import com.sample.nytimes.data.FeedsService
import com.sample.nytimes.data.beans.FeedCommentPost
import com.sample.nytimes.data.beans.response.FeedResponse
import com.sample.nytimes.di.NetworkModule

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * network datasource for feeds
 */
class FeedsRemoteSource {

    var feedsService: FeedsService = NetworkModule.provideRetrofit(NetworkModule.provideHttpClient())

    /**
     * this method is responsible to perform a network call to get latest feeds from NYT's server
     * [page] can be used to manage pagination
     * [callback] will be used to return data set on receive from server
     */
    suspend fun queryFeedsByPage(
        page: Int
    ): FeedResponse = feedsService.queryFeedsByPage(page)

    suspend fun postComments(
        comment: List<FeedCommentPost>
    ): FeedResponse = feedsService.postComments(comment)
}