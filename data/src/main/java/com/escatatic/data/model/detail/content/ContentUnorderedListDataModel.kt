package com.escatatic.data.model.detail.content

data class ContentUnorderedListDataModel(
    override val type: String,
    val id: String,
    val list: List<String>
): ContentSection