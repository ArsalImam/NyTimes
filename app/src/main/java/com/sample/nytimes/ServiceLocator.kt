package com.sample.nytimes

import androidx.annotation.VisibleForTesting
import com.sample.nytimes.data.FeedsRepository
import com.sample.nytimes.data.IFeedsRepository

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 */
object ServiceLocator {
    @Volatile
    var feedsRepository: IFeedsRepository? = null
        @VisibleForTesting set

    fun provideFeedsRepository(): IFeedsRepository {
        synchronized(this) {
            return feedsRepository ?: FeedsRepository()
        }
    }

    @VisibleForTesting
    fun resetRepository() {
        synchronized(this) {
            feedsRepository = null
        }
    }
}