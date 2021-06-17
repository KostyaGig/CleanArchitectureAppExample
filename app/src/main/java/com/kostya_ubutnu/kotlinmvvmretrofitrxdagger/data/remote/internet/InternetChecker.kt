package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.internet

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo

class InternetChecker(private val context: Context) {

    fun checkInternet(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        return true
    }
}