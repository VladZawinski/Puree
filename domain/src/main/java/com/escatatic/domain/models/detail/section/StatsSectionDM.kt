package com.escatatic.domain.models.detail.section

import com.escatatic.domain.models.detail.stats.StatsDomainModel

data class StatsSectionDM(
    override val type: String,
    override val item: StatsDomainModel
): DetailSection<StatsDomainModel>