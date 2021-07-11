package com.escatatic.data.repositories

import com.escatatic.data.service.PureeService
import com.escatatic.domain.repositories.RecipeDetailRepository
import timber.log.Timber
import javax.inject.Inject

class RecipeDetailRepositoryImpl @Inject constructor(
    private val service: PureeService
): RecipeDetailRepository {

    override suspend fun fetchDetail(id: String) {
        val result = service.getDetailSection(id)
        Timber.d("$result")
    }
}