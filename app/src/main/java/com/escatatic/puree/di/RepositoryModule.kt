package com.escatatic.puree.di

import com.escatatic.data.repositories.HomeRepositoryImpl
import com.escatatic.domain.repositories.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    internal abstract fun provideHomeRepository(impl: HomeRepositoryImpl): HomeRepository
}