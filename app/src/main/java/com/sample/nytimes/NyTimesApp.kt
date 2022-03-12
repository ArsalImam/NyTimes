package com.sample.nytimes

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * singleton application class for the app
 */
@HiltAndroidApp
class NyTimesApp : MultiDexApplication() {

    var isNetworkAvailable: MutableLiveData<Boolean> = MutableLiveData(true)

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        /**
         * instance object to use as context
         */
        lateinit var INSTANCE: NyTimesApp

    }
}