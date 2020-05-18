package com.sample.nytimes

import androidx.annotation.VisibleForTesting
import com.sample.nytimes.data.FeedsRepository
import com.sample.nytimes.data.IFeedsRepository

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * service locator object to create dependencies from single point (shorter implmentation for DI)
 * @see [Service Locator Pattern](https://developer.android.com/training/dependency-injection#di-alternatives)
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

}