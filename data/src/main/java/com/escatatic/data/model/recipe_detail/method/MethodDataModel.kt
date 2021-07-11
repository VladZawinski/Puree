package com.escatatic.data.model.recipe_detail.method

import com.squareup.moshi.Json

data class MethodDataModel(
    val step: Int,
    val method: String,
    val type: String,
    @field:Json(name = "_id")
    val id: String
)