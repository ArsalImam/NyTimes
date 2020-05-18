package com.sample.nytimes.feeds.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.nytimes.ServiceLocator
import com.sample.nytimes.data.IFeedsRepository
import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.utils.Callback
import com.sample.nytimes.utils.ViewUtils
import org.apache.commons.lang.math.NumberUtils

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 */
class FeedsViewModel : ViewModel() {
    /**
     * this will show manage the pagination for feeds api
     */
    private val page: Int = NumberUtils.INTEGER_ONE

    /**
     * respository for feeds data
     */
    private val feedsRepository: IFeedsRepository
        get() = ServiceLocator.provideFeedsRepository()

    /**
     * observable list of feeds which updates ui (on change)
     */
    private val _feedList =
        MutableLiveData<ArrayList<Feed>>().apply { value = ArrayList() }
    val feedList: LiveData<ArrayList<Feed>>
        get() = _feedList

    /**
     * observable boolean flag to handle refreshing loader ui
     */
    private val _isRefreshing =
        MutableLiveData<Boolean>().apply { value = false }
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing

    /**
     * this will be called by ui component to construct the required fields
     * require by the view model
     */
    fun init() = refreshFeeds()

    /**
     * this method will request repository to fetch (local/remote) data to show on ui
     */
    fun refreshFeeds() {
        _isRefreshing.value = true
        feedsRepository.queryFeedsByPage(page, object : Callback<ArrayList<Feed>> {
            override fun onResult(data: ArrayList<Feed>) {
                _isRefreshing.value = false
                _feedList.value = data
            }

            override fun onError(error: String) {
                _isRefreshing.value = false
                ViewUtils.showToast(error)
            }
        })
    }
}