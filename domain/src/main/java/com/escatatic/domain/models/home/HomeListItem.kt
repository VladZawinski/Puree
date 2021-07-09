package com.escatatic.domain.models.home

data class HomeListItem(
    override val type: String,
    override val name: String,
    override val item: List<Recipe>
): HomeItem<Recipe>