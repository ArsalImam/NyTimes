package com.sample.nytimes.utils

import android.widget.Toast
import com.sample.nytimes.NyTimesApp

/**
 * [author] by `Arsal Imam`
 * [created] on 5/17/2020
 */
object ViewUtils {
    fun showToast(message: String, length: Int = Toast.LENGTH_LONG) {
        Toast.makeText(NyTimesApp.INSTANCE, message, length).show()
    }
}