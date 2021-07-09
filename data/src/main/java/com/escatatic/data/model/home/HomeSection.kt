package com.escatatic.data.model.home

import com.escatatic.data.mappers.Mapper
import com.escatatic.domain.models.home.HomeListItem

data class HomeSection(
    val type: String,
    val name: String,
    val item: List<RecipeDataModel>
): Mapper<HomeListItem> {

    override suspend fun mapToDomain(): HomeListItem {
        return HomeListItem(type,name,item.map { it.mapToDomain() })
    }

}