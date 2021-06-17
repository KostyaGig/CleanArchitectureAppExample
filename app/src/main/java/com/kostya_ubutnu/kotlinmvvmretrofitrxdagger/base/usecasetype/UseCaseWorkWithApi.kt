package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.base.usecasetype

import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.models.Response

interface UseCaseWorkWithApi<R> {
    suspend fun getPostsFromInternet(): R
}