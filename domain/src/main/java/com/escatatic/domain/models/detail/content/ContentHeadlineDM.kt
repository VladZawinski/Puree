package com.escatatic.domain.models.detail.content

data class ContentHeadlineDM(
    val id: String,
    val headline: String,
    val content: String,
    override val type: String
): ContentChildSectionDM