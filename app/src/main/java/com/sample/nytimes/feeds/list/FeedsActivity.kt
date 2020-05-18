package com.sample.nytimes.feeds.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sample.nytimes.R
import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.databinding.ActivityFeedsBinding
import com.sample.nytimes.feeds.detail.FeedsDetailActivity
import com.sample.nytimes.generics.BaseAdapter
import com.sample.nytimes.utils.exts.obtainViewModel

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * this activity component can be used to show feed's listings
 */
class FeedsActivity : AppCompatActivity(), BaseAdapter.OnItemClickListener<Feed> {

    /**
     * Binding object between activity and xml file, it contains all objects
     * of UI components used by this activity
     */
    private lateinit var binding: ActivityFeedsBinding

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
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feeds)
        binding.apply {
            lifecycleOwner = this@FeedsActivity
            viewModel = obtainViewModel(FeedsViewModel::class.java).apply {
                init()
            }
        }
        setupRecyclerView()
    }

    /**
     * this method will setup or for initial configurations for recyclerview
     */
    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            adapter = BaseAdapter(R.layout.item_feeds, this@FeedsActivity)
        }
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