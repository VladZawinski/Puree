package com.escatatic.domain.models.detail.section

interface DetailSection<T> {
    val type: String
    val item: T
}