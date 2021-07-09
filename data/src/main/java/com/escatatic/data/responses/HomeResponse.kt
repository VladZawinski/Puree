package com.escatatic.data.responses

import com.escatatic.data.model.home.HomeSection

data class HomeResponse(
    val success: Boolean,
    val sections: List<HomeSection>
)