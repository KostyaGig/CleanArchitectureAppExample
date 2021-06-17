package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.di.module

import android.content.Context
import androidx.room.Room
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.DatabaseClient
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.DatabaseClientImpl
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.dao.PostDao
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.db.DATABASE_NAME
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.db.PostDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providePostDatabase(@ApplicationContext context: Context): PostDatabase
        = Room.databaseBuilder(
            context,
            PostDatabase ::class.java,
            DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun providePostDao(database: PostDatabase): PostDao
        = database.postDao()
}

