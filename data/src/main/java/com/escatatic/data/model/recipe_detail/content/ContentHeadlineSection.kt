package com.escatatic.data.model.recipe_detail.content

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ContentHeadlineSection(
    @Json(name = "_id")
    val id: String,
    val headline: String,
    val content: String
): ContentChildSection(ContentType.content_headline)