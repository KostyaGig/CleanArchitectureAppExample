package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils.extension

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.ViewModel
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.SecondActivity
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.MainActivity
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.R
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.models.Response
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.entites.Post

fun Activity.showMessage(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Activity.log(text: String) {
    Log.d("MainActivity", text)
}

@RequiresApi(Build.VERSION_CODES.O)
fun Activity.showNotification(channelId: String, title: String,text: String) {
    val notification = NotificationCompat.Builder(this)
        .apply {
            setSmallIcon(R.mipmap.ic_launcher)
            setContentTitle("Посты -> $title")
            setContentText(text)
            setChannelId(channelId)
        }.build()

    val notificationChannel1 = NotificationChannel(channelId,"Channel1",NotificationManager.IMPORTANCE_DEFAULT)
    notificationChannel1.description = "Описание channel1"

    val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(notificationChannel1)

    notificationManager.notify(1,notification)

    log("Show notification")
}

fun Activity.changeActivity(flag: Int) {
    if (flag == 1) {
        val activity = Intent(this,
            SecondActivity::class.java)
        startActivity(activity)
    } else {
        val activity = Intent(this,MainActivity::class.java)
        startActivity(activity)
    }

}

fun ViewModel.log(text: String) {
    Log.d("MainActivity", text)
}

fun List<Response>.topPost(): List<Post> {
    val posts = mutableListOf<Post>()
    this.forEach {response ->
        posts.add(Post(userId = response.userId,postId = response.postId,postBody = response.postBody,postTitle = response.postTitle,gettingPostTime = response.currentTime.toString()))
    }
    return posts
}
