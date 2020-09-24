package com.sample.nytimes.feeds.list

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.sample.nytimes.data.IFeedsRepository
import com.sample.nytimes.data.beans.Feed
import org.apache.commons.lang.math.NumberUtils

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 */
class FeedsViewModel @ViewModelInject constructor(
    feedsRepository: IFeedsRepository
) : ViewModel() {

    /**
     * this will show manage the pagination for feeds api
     */
    private val page: Int = NumberUtils.INTEGER_ONE

    /**
     * observable list of feeds which updates ui (on change)
     */
    val feedList: LiveData<ArrayList<Feed>> = feedsRepository
        .queryFeedsByPage(page).asLiveData()

    /**
     * observable boolean flag to handle refreshing loader ui
     */
    private val _isRefreshing =
        MutableLiveData<Boolean>().apply { value = false }
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing

    /**
     * this method will request repository to fetch (local/remote) data to show on ui
     */
    fun refreshFeeds() {
        _isRefreshing.value = true
    }
}