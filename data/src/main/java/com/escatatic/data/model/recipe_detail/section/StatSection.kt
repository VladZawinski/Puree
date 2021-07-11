package com.escatatic.data.model.recipe_detail.section

import com.escatatic.data.model.recipe_detail.stats.StatDataModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StatSection(
    val item: StatDataModel
): RecipeDetailSection(ViewType.stats)