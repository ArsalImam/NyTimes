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
 */
interface FeedsService {

    @GET(ApiConstants.LIST_FEEDS)
    fun queryFeedsByPage(
        @Path(ApiConstants.Request.PAGE) page: Int,
        @Query(ApiConstants.Request.API_KEY) apiKey: String = BuildConfig.NYC_API_LEY
    ): Call<FeedResponse>

    companion object {

        val connecton by lazy {
            invoke(BuildConfig.BASE_URL)
        }

        private val loggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }

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