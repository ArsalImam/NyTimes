package com.sample.nytimes.data

import com.sample.nytimes.BuildConfig
import com.sample.nytimes.data.beans.response.FeedResponse
import com.sample.nytimes.utils.ApiConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.apache.commons.lang.math.NumberUtils
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

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
    fun queryFeedsByPage(
        @Path(ApiConstants.Request.PAGE) page: Int,
        @Query(ApiConstants.Request.API_KEY) apiKey: String = BuildConfig.NYC_API_LEY
    ): Call<FeedResponse>

    companion object {

        /**
         * retrofit connection manager
         */
        val connecton by lazy {
            invoke(BuildConfig.BASE_URL)
        }

        /**
         * retrofit http interceptor to manage api logs, only available in debug view
         */
        private val loggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }

        /**
         * retrofit okhttp client to handle network calls
         */
        private val client: OkHttpClient =
            OkHttpClient.Builder().apply {
                followRedirects(true)
                followSslRedirects(true)
                retryOnConnectionFailure(true)
                cache(null)
                connectTimeout(NumberUtils.LONG_ONE, TimeUnit.MINUTES)
                readTimeout(NumberUtils.LONG_ONE, TimeUnit.MINUTES)
                writeTimeout(NumberUtils.LONG_ONE, TimeUnit.MINUTES)
                interceptors().add(loggingInterceptor)
            }.build()

        /**
         * this method will create a retrofit instance to execute server calls for feeds
         * [baseUrl] for nyt client
         */
        private operator fun invoke(baseUrl: String): FeedsService {
            return Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FeedsService::class.java)
        }
    }
}