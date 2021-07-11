package com.escatatic.data.model.recipe_detail.section

import com.escatatic.data.model.recipe_detail.method.MethodDataModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MethodSection(
    val item: List<MethodDataModel>
): RecipeDetailSection(ViewType.methods)