package com.escatatic.data.model.detail.twotypes

import com.escatatic.data.model.detail.DetailSection

data class MethodsDataModel(
    override val type: String,
    val item: List<MethodsDataModel>
): DetailSection