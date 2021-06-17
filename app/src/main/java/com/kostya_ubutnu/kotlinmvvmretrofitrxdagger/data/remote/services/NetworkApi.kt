package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.services

import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.models.Response
import retrofit2.http.GET

const val BASE_URL = "https://jsonplaceholder.typicode.com/"
interface NetworkApi {

    @GET("posts")
    suspend fun getPosts(): List<Response>

    @GET("posts")
    suspend fun getPostsByQuery(query: String): List<Response>
}