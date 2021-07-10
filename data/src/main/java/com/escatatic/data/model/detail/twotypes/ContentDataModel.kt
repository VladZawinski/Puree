package com.escatatic.data.model.detail.twotypes

import com.escatatic.data.model.detail.DetailSection
import com.escatatic.data.model.detail.content.ContentSection

data class ContentDataModel(
    override val type: String,
    val item: List<ContentSection>
): DetailSection