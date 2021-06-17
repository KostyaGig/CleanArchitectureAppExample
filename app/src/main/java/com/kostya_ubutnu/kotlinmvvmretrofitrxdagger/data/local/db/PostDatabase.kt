package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.dao.PostDao
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.singleton.SingletonHolder
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.presentation.entites.Post

const val DATABASE_NAME = "post-db"
const val DATABASE_VERSION = 1


@Database(
    entities = [Post::class],
    version = DATABASE_VERSION,
    exportSchema = false)
abstract class PostDatabase: RoomDatabase(){

    companion object {
        @Volatile
        private var INSTANCE: PostDatabase? = null

        fun getDatabase(context: Context): PostDatabase = INSTANCE ?: synchronized(this){
            val instance = Room.databaseBuilder(
                context,
                PostDatabase ::class.java,
                DATABASE_NAME
            ).build()
            INSTANCE = instance
            instance
        }
    }

//    companion object : SingletonHolder<PostDatabase, Context>({ applicationContext->
//        Room.databaseBuilder(applicationContext, PostDatabase::class.java, DATABASE_NAME).build()
//    })

    abstract fun postDao(): PostDao
}

