package com.sample.nytimes.feeds.list

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.sample.nytimes.NyTimesApp
import com.sample.nytimes.R
import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.databinding.ActivityFeedsBinding
import com.sample.nytimes.feeds.detail.FeedsDetailActivity
import com.sample.nytimes.utils.generics.BaseAdapter
import dagger.hilt.android.AndroidEntryPoint

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * this activity component can be used to show feed's listings
 */
@AndroidEntryPoint
class FeedsActivity : AppCompatActivity(), BaseAdapter.OnItemClickListener<Feed> {

    private val viewModel: FeedsViewModel by viewModels()

    /**
     * {@inheritDoc}
     *
     *
     * This will calls on every new initialization of this activity,
     * It can be used for any initializations or on start executions
     *
     * [savedInstanceState] to get data on activity state changed
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityFeedsBinding>(this, R.layout.activity_feeds).apply {
            lifecycleOwner = this@FeedsActivity
            viewModel = this@FeedsActivity.viewModel
            recyclerView.apply {
                adapter = BaseAdapter(R.layout.item_feeds, this@FeedsActivity)
            }
        }

        NyTimesApp.INSTANCE.isNetworkAvailable.observe(this) {
            if (it) viewModel.syncComments()
        }

        //Example for post comment from view
        viewModel.postComment("My name is Arsal")
    }


    /**
     * this method will invoke by the adapter, when any of the feed cell tapped
     *
     * [item] object is the tapped object
     */
    override fun onItemClick(item: Feed) {
        FeedsDetailActivity.openActivity(this@FeedsActivity, item)
    }
}