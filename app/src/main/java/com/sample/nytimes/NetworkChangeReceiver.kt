package com.sample.nytimes

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class NetworkChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) =
        NyTimesApp.INSTANCE.isNetworkAvailable.postValue(checkInternet(context))

    private fun checkInternet(context: Context?): Boolean {
        (context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)?.let {
            val wifi = it.getNetworkInfo(ConnectivityManager.TYPE_WIFI)

            val mobile = it.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
            return wifi.isAvailable || mobile.isAvailable
        }
        return false
    }
}