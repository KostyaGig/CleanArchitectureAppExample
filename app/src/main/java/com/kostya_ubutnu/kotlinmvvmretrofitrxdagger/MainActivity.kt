package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding

import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.entites.Post
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.recyclerview.adapter.PostAdapter
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.viewmodel.MainViewModel
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils.extension.changeActivity
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils.extension.log
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils.extension.showMessage
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils.extension.showNotification
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils.state.DataStore
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.utils.state.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject
import kotlin.math.log

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    private lateinit var recyclerView: RecyclerView
    private val postAdapter = PostAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.posts_rec_view)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }

        viewModel.getPosts()
        
    }

    override fun onStart() {
        super.onStart()
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect {state ->
                when (state) {
                    is UiState.EmptyListFromCacheState -> showMessage("Empty cache")
                    is UiState.LoadingState -> {

                    }
                    is UiState.Success -> {
                        if (state.dataStore is DataStore.Local) {
                            showNotification(channelId = "channel1Id",text = "Из кэша было получено ${state.data.size} постов",title = state.data.size.toString())
                        } else {
                            showNotification(channelId = "channel1Id",text = "Из интернето загружено ${state.data.size} постов",title = state.data.size.toString())
                        }
                        postAdapter.submitList(state.data)
                    }
                    is UiState.Failure -> showMessage(state.message)
                    else -> showMessage("Else branch")
                }
            }
        }
    }

}
