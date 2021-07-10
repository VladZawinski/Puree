package com.escatatic.data.model.detail.ingredient

data class IngredientParentDataModel(
    override val id: String,
    override val name: String,
    override val list: List<IngredientChildDataModel>
): IngredientSection<IngredientChildDataModel>