package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local

import android.app.Application
import android.content.Context
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.dao.PostDao
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.db.PostDatabase
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.entites.Post
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DatabaseClientImpl @Inject constructor(
    private val postDao: PostDao
): DatabaseClient {

    suspend fun savePosts(posts: List<Post>) = postDao.savePost(posts)

    fun getPosts() = postDao.getPosts()
}