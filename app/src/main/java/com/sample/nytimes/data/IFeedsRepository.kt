package com.sample.nytimes.data

import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.utils.Callback

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
    fun queryFeedsByPage(page: Int, callback: Callback<ArrayList<Feed>>)
}