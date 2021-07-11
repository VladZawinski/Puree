package com.escatatic.puree.di

import android.content.Context
import com.crazylegend.retrofit.interceptors.ForceCacheInterceptor
import com.crazylegend.retrofit.interceptors.GzipRequestInterceptor
import com.crazylegend.retrofit.interceptors.NetworkCacheInterceptor
import com.escatatic.data.converters.DetailSectionConverter
import com.escatatic.data.model.recipe_detail.content.*
import com.escatatic.data.model.recipe_detail.section.*
import com.escatatic.data.service.PureeService
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
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
            .add(
                PolymorphicJsonAdapterFactory.of(RecipeDetailSection::class.java,"type")
                    .withSubtype(CarouselSection::class.java,ViewType.carousel.name)
                    .withSubtype(TitleSection::class.java,ViewType.title.name)
                    .withSubtype(OverviewSection::class.java,ViewType.overview.name)
                    .withSubtype(MethodSection::class.java,ViewType.methods.name)
                    .withSubtype(StatSection::class.java,ViewType.stats.name)
                    .withSubtype(ContentSection::class.java,ViewType.content.name)
                    .withSubtype(IngredientSection::class.java,ViewType.ingredients.name)
            )
            .add(
                PolymorphicJsonAdapterFactory.of(ContentChildSection::class.java,"type")
                    .withSubtype(ContentHeadlineSection::class.java,ContentType.content_headline.name)
                    .withSubtype(ContentImageSection::class.java,ContentType.content_image.name)
                    .withSubtype(ContentImageGridSection::class.java,ContentType.content_image_grid.name)
                    .withSubtype(ContentUnorderedListSection::class.java,ContentType.unorder_list.name)
                    .withSubtype(ContentTextSection::class.java,ContentType.content_text.name)
            )
            .add(KotlinJsonAdapterFactory())
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