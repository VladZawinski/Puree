package com.escatatic.domain.repositories

interface RecipeDetailRepository {
    suspend fun fetchDetail(id: String)
}