package com.sample.nytimes

import android.app.Application
import androidx.multidex.MultiDexApplication

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 * singleton application class for the app
 */
class NyTimesApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        /**
         * instance object to use as context
         */
        lateinit var INSTANCE: Application
    }
}