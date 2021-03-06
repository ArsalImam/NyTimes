package com.sample.nytimes.di

import com.sample.nytimes.BuildConfig
import com.sample.nytimes.data.FeedsRepository
import com.sample.nytimes.data.FeedsService
import com.sample.nytimes.data.IFeedsRepository
import com.sample.nytimes.data.sources.FeedsRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.apache.commons.lang.math.NumberUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DataSourceModule {
    @Singleton
    @Provides
    fun provideFeedsDataSource(): FeedsRemoteSource = FeedsRemoteSource()
}

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideFeedsRepository(remoteDataSource: FeedsRemoteSource): IFeedsRepository {
        return FeedsRepository(remoteDataSource)
    }
}

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    /**
     * retrofit http interceptor to manage api logs, only available in debug view
     */
    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor.Level {
        return if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
    }

    /**
     * retrofit okhttp client to handle network calls
     */
    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            followRedirects(true)
            followSslRedirects(true)
            retryOnConnectionFailure(true)
            cache(null)
            connectTimeout(NumberUtils.LONG_ONE, TimeUnit.MINUTES)
            readTimeout(NumberUtils.LONG_ONE, TimeUnit.MINUTES)
            writeTimeout(NumberUtils.LONG_ONE, TimeUnit.MINUTES)
//            interceptors().add(loggingInterceptor)
        }.build()
    }

    /**
     * this method will create a retrofit instance to execute server calls for feeds
     * [baseUrl] for nyt client
     */
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): FeedsService {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FeedsService::class.java)
    }
}