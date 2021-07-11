package com.escatatic.data.model.recipe_detail.content

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ContentUnorderedListSection(
    @Json(name = "_id")
    val id: String,
    val list: List<String>
): ContentChildSection(ContentType.unorder_list)