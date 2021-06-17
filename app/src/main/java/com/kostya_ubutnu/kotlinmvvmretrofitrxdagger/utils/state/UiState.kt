package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils.state

import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.models.Response
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.entites.Post

sealed class UiState {
    object EmptyListFromCacheState: UiState()
    object LoadingState: UiState()
    data class Success(val dataStore: DataStore,val data: List<Post>): UiState()
    data class Failure(val message: String): UiState()
}

sealed class DataStore {
    object Local: DataStore()
    object Remote: DataStore()
}