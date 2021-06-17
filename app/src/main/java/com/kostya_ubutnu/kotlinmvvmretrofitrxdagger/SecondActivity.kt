package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.R
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils.extension.changeActivity
import kotlinx.coroutines.delay

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    override fun onResume() {
        super.onResume()
//        lifecycleScope.launchWhenResumed {
//            delay(500)
//            changeActivity(100)
//        }
    }
}