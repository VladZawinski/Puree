package com.escatatic.data.model.recipe_detail.section

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
sealed class RecipeDetailSection(
    @field:Json(name = "type")
    val type: ViewType
)
