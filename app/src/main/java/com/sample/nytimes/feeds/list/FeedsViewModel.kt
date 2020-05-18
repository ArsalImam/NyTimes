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
    private val page: Int = NumberUtils.INTEGER_ONE

    private val feedsRepository: IFeedsRepository
        get() = ServiceLocator.provideFeedsRepository()

    private val _feedList =
        MutableLiveData<ArrayList<Feed>>().apply { value = ArrayList() }
    val feedList: LiveData<ArrayList<Feed>>
        get() = _feedList

    private val _isRefreshing =
        MutableLiveData<Boolean>().apply { value = false }
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing

    fun init() = refreshFeeds()

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