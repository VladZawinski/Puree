package com.escatatic.data.responses

import com.escatatic.data.model.recipe_detail.section.RecipeDetailSection
import com.squareup.moshi.Json

data class DetailResponse(
    val type: String,
    @Json(name = "sections")
    val item: List<RecipeDetailSection>
)