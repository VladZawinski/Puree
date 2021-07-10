package com.escatatic.data.model.detail.twotypes

import com.escatatic.data.model.detail.DetailSection

data class OverViewDataModel(
    override val type: String,
    val item: String
): DetailSection