package com.escatatic.data.model.detail.ingredient

interface IngredientSection<T> {
    val id: String
    val name: String
    val list: List<T>
}