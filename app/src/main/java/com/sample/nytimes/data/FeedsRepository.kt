package com.sample.nytimes.data

import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.data.sources.FeedsRemoteSource
import com.sample.nytimes.utils.Callback

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * this repository is responsible to manage data transactions related feed
 * [remoteDataSource] network datasource for feeds
 */
class FeedsRepository(private val remoteDataSource: FeedsRemoteSource = FeedsRemoteSource()) :
    IFeedsRepository {

    /**
     * this method is responsible to perform a network call to get latest feeds from NYT's server
     * [page] can be used to manage pagination
     * [callback] will be used to return data set on receive from server
     */
    override fun queryFeedsByPage(page: Int, callback: Callback<ArrayList<Feed>>) =
        remoteDataSource.queryFeedsByPage(page, callback)
}