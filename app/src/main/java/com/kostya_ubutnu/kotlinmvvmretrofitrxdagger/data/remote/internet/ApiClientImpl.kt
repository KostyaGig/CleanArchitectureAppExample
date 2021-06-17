package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.internet

import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.services.NetworkApi
import javax.inject.Inject

class ApiClientImpl @Inject constructor(private val networkApi: NetworkApi): ApiClient {

    suspend fun getPosts() = networkApi.getPosts()

    suspend fun getPostsByQuery(query: String) = networkApi.getPostsByQuery(query)
}