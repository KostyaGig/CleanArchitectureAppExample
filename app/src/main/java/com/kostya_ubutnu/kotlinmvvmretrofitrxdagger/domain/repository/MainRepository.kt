package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.domain.repository

import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.models.Response
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.entites.Post
import kotlinx.coroutines.flow.Flow


interface MainRepository {

    suspend fun getPostsFromInternet(): List<Response>

    fun getPostsFromDatabase(): Flow<List<Post>>

    suspend fun savePosts(posts: List<Post>)

}