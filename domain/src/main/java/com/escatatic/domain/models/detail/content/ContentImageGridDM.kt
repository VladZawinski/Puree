package com.escatatic.domain.models.detail.content

data class ContentImageGridDM(
    override val type: String,
    val id: String,
    val images: List<String>
): ContentChildSectionDM