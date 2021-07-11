package com.escatatic.puree.di

import com.escatatic.data.repositories.HomeRepositoryImpl
import com.escatatic.data.repositories.RecipeDetailRepositoryImpl
import com.escatatic.domain.repositories.HomeRepository
import com.escatatic.domain.repositories.RecipeDetailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RepositoryModule {

    @ActivityRetainedScoped
    @Binds
    internal abstract fun provideHomeRepository(impl: HomeRepositoryImpl): HomeRepository

    @ActivityRetainedScoped
    @Binds
    internal abstract fun provideRecipeDetailRepository(impl: RecipeDetailRepositoryImpl): RecipeDetailRepository
}