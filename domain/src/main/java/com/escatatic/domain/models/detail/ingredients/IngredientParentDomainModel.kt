package com.escatatic.domain.models.detail.ingredients

data class IngredientParentDomainModel(
    val id: String,
    val name: String,
    val list: List<IngredientDomainModel>
)