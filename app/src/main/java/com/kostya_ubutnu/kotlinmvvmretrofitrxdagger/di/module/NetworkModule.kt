package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.di.module

import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.services.BASE_URL
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.services.NetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideApiService(): NetworkApi
        = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkApi::class.java)

}