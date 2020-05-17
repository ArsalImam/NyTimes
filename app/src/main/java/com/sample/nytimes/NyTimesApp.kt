package com.sample.nytimes

import android.app.Application
import androidx.multidex.MultiDexApplication

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 *
 */
class NyTimesApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: Application
    }
}