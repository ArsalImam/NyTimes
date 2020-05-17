package com.sample.nytimes.data

import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.data.sources.FeedsRemoteSource
import com.sample.nytimes.utils.Callback

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 */
class FeedsRepository(val remoteDataSource: FeedsRemoteSource = FeedsRemoteSource()) :
    IFeedsRepository {

    override fun queryFeedsByPage(page: Int, callback: Callback<ArrayList<Feed>>) =
        remoteDataSource.queryFeedsByPage(page, callback)
}