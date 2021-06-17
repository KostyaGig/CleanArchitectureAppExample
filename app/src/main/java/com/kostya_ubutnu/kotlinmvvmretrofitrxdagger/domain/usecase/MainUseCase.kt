package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.domain.usecase

import android.app.Application
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.base.usecasetype.UseCaseWorkWithApi
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.base.usecasetype.UseCaseWorkWithLocalDatabase
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.models.Response
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.repository.MainRepositoryImpl
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.entites.Post
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils.extension.topPost
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainUseCase @Inject constructor(private val repository: MainRepositoryImpl):
    UseCaseWorkWithApi<List<Response>>,
    UseCaseWorkWithLocalDatabase<Flow<List<Post>>>
{

    override suspend fun getPostsFromInternet(): List<Response> {
        return withContext(Dispatchers.IO) {
            val posts: Deferred<List<Response>> = async { repository.getPostsFromInternet() }
            supervisorScope {
                repository.savePosts(posts.await().topPost())
            }

            posts.await()
        }
    }

    override fun getPostsFromDatabase() = repository.getPostsFromDatabase()
}