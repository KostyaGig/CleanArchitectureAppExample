package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.dao

import androidx.room.*
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.entites.Post
import kotlinx.coroutines.flow.Flow


@Dao
interface PostDao {

    @Query("SELECT * FROM mytable")
    fun getPosts(): Flow<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePost(posts: List<Post>)

    @Query("DELETE FROM mytable")
    suspend fun deletePost(): Int
}