package com.escatatic.data.repositories

import com.escatatic.data.service.PureeService
import com.escatatic.domain.models.home.HomeListItem
import com.escatatic.domain.repositories.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val service: PureeService
): HomeRepository  {

    override suspend fun fetchHomeSection(): List<HomeListItem> = withContext(Dispatchers.IO){
        service.getHomeSection().sections.map { it.mapToDomain() }
    }


}