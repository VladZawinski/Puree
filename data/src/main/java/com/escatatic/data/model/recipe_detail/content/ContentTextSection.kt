package com.escatatic.data.model.recipe_detail.content

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ContentTextSection(
    @Json(name = "_id")
    val id: String,
    val content: String,
    val headline: String,
): ContentChildSection(ContentType.content_text)