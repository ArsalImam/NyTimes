package com.sample.nytimes.data.sources

import com.sample.nytimes.data.FeedsService
import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.generics.GenericNetworkCallback
import com.sample.nytimes.utils.Callback

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 */
class FeedsRemoteSource {
    fun queryFeedsByPage(
        page: Int,
        callback: Callback<ArrayList<Feed>>
    ) = FeedsService.connecton.queryFeedsByPage(page).enqueue(GenericNetworkCallback(callback))
}