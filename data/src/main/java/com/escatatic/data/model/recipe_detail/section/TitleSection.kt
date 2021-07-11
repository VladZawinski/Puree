package com.escatatic.data.model.recipe_detail.section

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class TitleSection(
    val item: String
): RecipeDetailSection(ViewType.title)