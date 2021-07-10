package com.escatatic.data.model.detail.content

data class ContentImageGridDataModel(
    override val type: String,
    val id: String,
    val images: List<String>
): ContentSection