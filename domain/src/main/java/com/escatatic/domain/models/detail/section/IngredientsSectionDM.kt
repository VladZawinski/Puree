package com.escatatic.domain.models.detail.section

import com.escatatic.domain.models.detail.ingredients.IngredientParentDomainModel

data class IngredientsSectionDM(
    override val type: String,
    override val item: List<IngredientParentDomainModel>
): DetailSection<List<IngredientParentDomainModel>>