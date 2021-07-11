package com.escatatic.domain.models.detail.section

data class OverviewSectionDM(
    override val type: String,
    override val item: String
): DetailSection<String>