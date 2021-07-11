package com.escatatic.domain.models.detail.section

import com.escatatic.domain.models.detail.methods.MethodDomainModel

data class MethodSectionDM(
    override val type: String,
    override val item: List<MethodDomainModel>
): DetailSection<List<MethodDomainModel>>