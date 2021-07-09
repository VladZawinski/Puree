package com.escatatic.domain.models.home

interface HomeItem<T> {
    val type: String
    val name: String
    val item: List<T>
}