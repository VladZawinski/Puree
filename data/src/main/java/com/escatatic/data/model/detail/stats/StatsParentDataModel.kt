package com.escatatic.data.model.detail.stats

import com.escatatic.data.model.detail.DetailSection

data class StatsParentDataModel(
    override val type: String,
    override val item: StatsDataModel
): DetailSection<StatsDataModel>