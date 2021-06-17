package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils

import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.models.Response

class PostMapper<K: Number,T>(val postsInsertId: K,val data: T) {
    fun getData(): PostMap<K,T> {
        return PostMap(postsInsertId,data)
    }
}

data class PostMap<K: Number,T>(
    val postsInsertId: K,
    val data: T
)