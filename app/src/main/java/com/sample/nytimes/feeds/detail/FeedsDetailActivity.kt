package com.sample.nytimes.feeds.detail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sample.nytimes.R
import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.databinding.ActivityFeedDetailBinding
import com.sample.nytimes.feeds.list.FeedsActivity

/**
 * [author] by `Arsal Imam`
 * [created] on 5/18/2020
 */
class FeedsDetailActivity : AppCompatActivity() {
    private val feed: Feed by lazy { intent.extras?.get(EXTRA_FEED_DETAIL) as Feed }

    private lateinit var binding: ActivityFeedDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feed_detail)
        binding.apply {
            lifecycleOwner = this@FeedsDetailActivity
            feed = this@FeedsDetailActivity.feed
        }
    }

    companion object {
        private const val EXTRA_FEED_DETAIL: String = "feed_detail"

        fun openActivity(
            activity: Activity,
            feed: Feed
        ) {
            val intent = Intent(activity, FeedsActivity::class.java)
            intent.putExtra(EXTRA_FEED_DETAIL, feed)
            activity.startActivity(intent)
        }
    }
}