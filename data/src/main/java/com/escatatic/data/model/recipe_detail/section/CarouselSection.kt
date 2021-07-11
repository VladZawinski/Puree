package com.escatatic.data.model.recipe_detail.section

import com.google.gson.annotations.JsonAdapter
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CarouselSection(
    val item: String
): RecipeDetailSection(ViewType.carousel)