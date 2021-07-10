package com.escatatic.data.model.detail.content

data class ContentSingleImageDataModel(
    override val type: String,
    val id: String,
    val images: List<String>
): ContentSection