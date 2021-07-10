package com.escatatic.data.model.detail.twotypes

import com.escatatic.data.model.detail.DetailSection
import com.escatatic.data.model.detail.ingredient.IngredientParentDataModel

data class IngredientDataModel(
    override val type: String,
    val item: List<IngredientParentDataModel>
): DetailSection