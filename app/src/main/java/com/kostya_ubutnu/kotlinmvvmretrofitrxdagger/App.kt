package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class App : Application() {

    companion object {
        const val TAG = "MainActivity"
        val savePostsScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
        val testScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    }



    override fun onCreate() {
        super.onCreate()
    }
}