package com.escatatic.puree.di

import android.content.Context
import com.crazylegend.retrofit.interceptors.ForceCacheInterceptor
import com.crazylegend.retrofit.interceptors.GzipRequestInterceptor
import com.crazylegend.retrofit.interceptors.NetworkCacheInterceptor
import com.escatatic.data.converters.DetailSectionConverter
import com.escatatic.data.service.PureeService
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context
    ) = OkHttpClient.Builder()
        .addInterceptor(GzipRequestInterceptor())
        .addNetworkInterceptor(NetworkCacheInterceptor())
        .addNetworkInterceptor(ForceCacheInterceptor(context))
        .addNetworkInterceptor(HttpLoggingInterceptor())
        .build()

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(DetailSectionConverter())
            .build()
    }

    @Provides
    @Singleton
    fun providePureeService(okHttpClient: OkHttpClient,moshi: Moshi) = Retrofit.Builder()
        .baseUrl("http://139.162.11.169:8080/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(PureeService::class.java)

}