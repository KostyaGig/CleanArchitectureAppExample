package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.base.usecasetype

interface UseCaseWorkWithLocalDatabase<R> {
    fun getPostsFromDatabase(): R
}