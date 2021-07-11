package com.escatatic.data.model.recipe_detail.ingredients

import com.squareup.moshi.Json

data class IngredientParentDataModel(
    @Json(name = "_id")
    val id: String,
    val name: String,
    val list: List<IngredientDataModel>
)