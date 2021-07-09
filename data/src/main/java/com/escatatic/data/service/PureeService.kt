package com.escatatic.data.service

import com.escatatic.data.responses.HomeResponse
import retrofit2.http.GET


interface PureeService {

    @GET("api/home")
    suspend fun getHomeSection(): HomeResponse
}