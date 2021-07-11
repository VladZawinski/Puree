package com.escatatic.data.model.recipe_detail.section

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OverviewSection (
    val item: String
): RecipeDetailSection(ViewType.overview)