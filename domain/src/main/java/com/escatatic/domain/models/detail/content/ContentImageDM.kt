package com.escatatic.domain.models.detail.content

data class ContentImageDM(
    val id: String,
    val images: List<String>,
    override val type: String
): ContentChildSectionDM