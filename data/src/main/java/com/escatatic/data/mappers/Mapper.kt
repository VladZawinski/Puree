package com.escatatic.data.mappers

interface Mapper<T> {
    suspend fun mapToDomain(): T
}