package com.escatatic.data.model.detail.content

data class HeadlineContentDataModel(
    override val type: String,
    val id: String,
    val headline: String,
    val content: String
): ContentSection