package com.escatatic.data.model.home

import com.escatatic.data.mappers.Mapper
import com.escatatic.domain.models.home.Recipe
import com.squareup.moshi.Json

data class RecipeDataModel(
    @Json(name = "_id")
    val id: String,
    val title: String,
    @Json(name = "heroImage")
    val coverImage: String,
    val createdAt: String
): Mapper<Recipe> {

    override suspend fun mapToDomain(): Recipe {
        return Recipe(id, title, coverImage, createdAt)
    }

}