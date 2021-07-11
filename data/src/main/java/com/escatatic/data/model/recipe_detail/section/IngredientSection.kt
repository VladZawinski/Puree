package com.escatatic.data.model.recipe_detail.section

import com.escatatic.data.model.recipe_detail.ingredients.IngredientParentDataModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IngredientSection(
    val item: List<IngredientParentDataModel>
): RecipeDetailSection(ViewType.ingredients)