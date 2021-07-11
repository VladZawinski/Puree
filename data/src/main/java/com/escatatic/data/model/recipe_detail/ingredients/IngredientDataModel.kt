package com.escatatic.data.model.recipe_detail.ingredients

import com.squareup.moshi.Json

data class IngredientDataModel(
    @Json(name = "_id")
    val id: String,
    val amount: String,
    val name: String
)