package com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.di.module

import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.base.usecasetype.UseCaseWorkWithApi
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.DatabaseClient
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.local.DatabaseClientImpl
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.remote.models.Response
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.data.repository.MainRepositoryImpl
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.domain.repository.MainRepository
import com.kostya_ubutnu.kotlinmvvmretrofitrxdagger.domain.usecase.MainUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BaseModule {

    @Binds
    abstract fun bindMainRepository(
        repositoryImpl: MainRepositoryImpl
    ): MainRepository

    @Singleton
    @Binds
    abstract fun bindDatabaseClient(
        client: DatabaseClientImpl
    ): DatabaseClient

}