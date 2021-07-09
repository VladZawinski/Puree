package com.escatatic.domain.repositories

import com.escatatic.domain.models.home.HomeListItem

interface HomeRepository {
    suspend fun fetchHomeSection(): List<HomeListItem>
}