package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.repository

import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.DatabaseClientImpl
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.internet.ApiClientImpl
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.domain.repository.MainRepository
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.entites.Post
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val databaseClient: DatabaseClientImpl,
    private val serviceApiClient: ApiClientImpl
): MainRepository {

    override suspend fun getPostsFromInternet() = serviceApiClient.getPosts()

    override fun getPostsFromDatabase() = databaseClient.getPosts()

    override suspend fun savePosts(posts: List<Post>) {
        databaseClient.savePosts(posts)
    }
}