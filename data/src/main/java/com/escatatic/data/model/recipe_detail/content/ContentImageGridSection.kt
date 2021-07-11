package com.escatatic.data.model.recipe_detail.content

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ContentImageGridSection(
    @Json(name = "_id")
    val id: String,
    val images: List<String>
): ContentChildSection(ContentType.content_image_grid)