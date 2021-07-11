package com.escatatic.data.model.home

import com.escatatic.data.mappers.Mapper
import com.escatatic.domain.models.home.HomeListItem
import com.squareup.moshi.Json

data class HomeSection(
    @Json(name = "type")
    val type: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "item")
    val item: List<RecipeDataModel>
): Mapper<HomeListItem> {

    override suspend fun mapToDomain(): HomeListItem {
        return HomeListItem(type,name,item.map { it.mapToDomain() })
    }

}