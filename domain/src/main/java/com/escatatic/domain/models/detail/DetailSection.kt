package com.escatatic.domain.models.detail

interface DetailSection<T> {
    val type: String
    val item: T
}