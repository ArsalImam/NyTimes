package com.sample.nytimes.feeds.detail

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sample.nytimes.R
import com.sample.nytimes.data.beans.Feed
import com.sample.nytimes.databinding.ActivityFeedDetailBinding

/**
 * [author] by `Arsal Imam`
 * [created] on 5/18/2020
 *
 * this activity component can be used to show feed's detail
 */
class FeedsDetailActivity : AppCompatActivity() {

    /**
     * feeds object, all ui is populating from this object,
     * [EXTRA_FEED_DETAIL] will be used here to get data from intent
     */
    private val feed: Feed by lazy { intent.extras?.get(EXTRA_FEED_DETAIL) as Feed }

    /**
     * Binding object between activity and xml file, it contains all objects
     * of UI components used by this activity
     */
    private lateinit var binding: ActivityFeedDetailBinding

    /**
     * {@inheritDoc}
     *
     * This will calls on every new initialization of this activity,
     * It can be used for any initializations or on start executions
     *
     * [savedInstanceState] to get data on activity state changed
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feed_detail)
        binding.apply {
            lifecycleOwner = this@FeedsDetailActivity
            feed = this@FeedsDetailActivity.feed
        }
        setupToolbar()
    }

    /**
     * this method will setup or for initial configurations for toolbar
     */
    private fun setupToolbar() {
        setSupportActionBar(binding.toolBar)
        binding.collapseToolbar.setExpandedTitleColor(Color.TRANSPARENT)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    companion object {

        /**
         * this constant will be used as key to share feed object between activity
         */
        private const val EXTRA_FEED_DETAIL: String = "feed_detail"

        /**
         * This method is used to open withdrawal activity by using intent API mentioned by android docs.
         * For more info on intents, refers the below URL,
         * @see [Intents](https://developer.android.com/reference/android/content/Intent)
         *
         * [activity] context to open withdrawal activity
         * [feed] to share with between activities
         */
        fun openActivity(
            activity: Activity,
            feed: Feed
        ) {
            val intent = Intent(activity, FeedsDetailActivity::class.java)
            intent.putExtra(EXTRA_FEED_DETAIL, feed)
            activity.startActivity(intent)
        }
    }
}