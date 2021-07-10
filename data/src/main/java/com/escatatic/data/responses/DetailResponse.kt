package com.escatatic.data.responses

import com.escatatic.data.model.detail.DetailSection

data class DetailResponse(
    val type: String,
    val sections: List<DetailSection>
)