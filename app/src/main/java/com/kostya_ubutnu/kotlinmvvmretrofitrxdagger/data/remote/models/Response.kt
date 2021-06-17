package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.models

import com.google.gson.annotations.SerializedName
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.entites.Post

data class Response(
    @SerializedName("userId")
    val userId:Int,
    @SerializedName("id")
    val postId:Int,
    @SerializedName("title")
    val postTitle:String,
    @SerializedName("body")
    val postBody:String

) {
    val currentTime = System.currentTimeMillis()

    fun printResponse() = "*Response* userId -> $userId, postid -> $postId, post title-> $postTitle, timeGettingPost-> $currentTime"
}