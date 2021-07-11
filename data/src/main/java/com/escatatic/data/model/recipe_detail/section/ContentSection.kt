package com.escatatic.data.model.recipe_detail.section

import com.escatatic.data.model.recipe_detail.content.ContentChildSection
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ContentSection(
    val item: List<ContentChildSection>
): RecipeDetailSection(ViewType.content)