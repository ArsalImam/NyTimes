package com.sample.nytimes.feeds

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sample.nytimes.R
import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.databinding.ActivityFeedsBinding
import com.sample.nytimes.generics.BaseAdapter
import com.sample.nytimes.utils.exts.obtainViewModel

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 */
class FeedsActivity : AppCompatActivity(), BaseAdapter.OnItemClickListener<Feed> {

    private lateinit var binding: ActivityFeedsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feeds)
        binding.lifecycleOwner = this
        binding.viewModel = obtainViewModel(FeedsViewModel::class.java).apply {
            init()
        }
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            adapter = BaseAdapter(R.layout.item_feeds, this@FeedsActivity)
        }
    }

    override fun onItemClick(item: Feed) {

    }
}