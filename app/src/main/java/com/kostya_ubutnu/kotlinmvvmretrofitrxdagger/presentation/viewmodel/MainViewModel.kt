package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.App
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.internet.InternetChecker
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.domain.usecase.MainUseCase
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils.extension.topPost
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils.state.DataStore
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.net.UnknownHostException
import javax.inject.Inject

class MainViewModel @Inject constructor(private val useCase: MainUseCase): ViewModel() {

//    private val internetChecker = InternetChecker(application)

    private val _uiState = MutableStateFlow<UiState>(UiState.LoadingState)
    val uiState: StateFlow<UiState> get() = _uiState

    private val exceptionHandler = CoroutineExceptionHandler {_,exception ->
        Log.d(App.TAG,"${exception::class.java}")
        if (exception is UnknownHostException) {
            _uiState.value = UiState.Failure("Нет интернета")
        }
    }

    fun getPosts(){
        viewModelScope.launch(exceptionHandler) {
            _uiState.value = UiState.LoadingState
            if (false) {
                useCase.getPostsFromDatabase().collect {posts ->
                    Log.d(App.TAG, "getPosts: ")
                    Log.d("MainActivity","POST SIZE -> ${posts.size}")
                    if (posts.isEmpty()) {
                        _uiState.value = UiState.EmptyListFromCacheState
                        Log.d("MainActivity","Post size -> ${posts.size}")
                    } else {
                        _uiState.value = UiState.Success(DataStore.Local,posts)
                    }
                }
            } else {
                val posts = useCase.getPostsFromInternet().topPost()
                _uiState.value = UiState.Success(DataStore.Remote,posts)
            }
        }
    }

}