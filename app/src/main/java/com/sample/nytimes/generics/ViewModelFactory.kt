package com.sample.nytimes.generics

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sample.nytimes.feeds.list.FeedsViewModel

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * View Model Factory
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(FeedsViewModel::class.java) -> FeedsViewModel()
                else -> throw IllegalArgumentException("Unknown viewModel class $modelClass")
            }
        } as T


    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance() =
            instance
                ?: synchronized(ViewModelFactory::class.java) {
                    instance
                        ?: ViewModelFactory()
                            .also { instance = it }
                }
    }
}