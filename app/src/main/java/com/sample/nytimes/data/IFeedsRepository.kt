package com.sample.nytimes.data

import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.utils.Callback

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 */
interface IFeedsRepository {
    fun queryFeedsByPage(page: Int, callback: Callback<ArrayList<Feed>>)
}