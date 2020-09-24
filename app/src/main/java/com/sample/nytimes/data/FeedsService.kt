package com.sample.nytimes.data

import com.sample.nytimes.BuildConfig
import com.sample.nytimes.data.beans.response.FeedResponse
import com.sample.nytimes.utils.ApiConstants
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * network client to handle feed's services
 */
interface FeedsService {

    /**
     * this method is responsible to perform a network call to get latest feeds from NYT's server
     * [page] can be used to manage pagination
     * [callback] will be used to return data set on receive from server
     */
    @GET(ApiConstants.LIST_FEEDS)
    suspend fun queryFeedsByPage(
        @Path(ApiConstants.Request.PAGE) page: Int,
        @Query(ApiConstants.Request.API_KEY) apiKey: String = BuildConfig.NYC_API_LEY
    ): FeedResponse
}