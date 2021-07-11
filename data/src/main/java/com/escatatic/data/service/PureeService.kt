package com.escatatic.data.service

import com.escatatic.data.responses.DetailResponse
import com.escatatic.data.responses.HomeResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PureeService {

    @GET("api/home")
    suspend fun getHomeSection(): HomeResponse

    @GET("api/detail")
    suspend fun getDetailSection(
        @Query("id") id: String
    ): DetailResponse

}