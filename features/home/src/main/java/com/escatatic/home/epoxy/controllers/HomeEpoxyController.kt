package com.escatatic.home.epoxy.controllers

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.TypedEpoxyController
import com.escatatic.domain.models.home.HomeListItem
import com.escatatic.home.epoxy.models.HeaderModel
import com.escatatic.home.epoxy.models.HeaderModel_
import com.escatatic.home.epoxy.models.LabelModel_
import com.escatatic.home.epoxy.models.RecipeModel_
import timber.log.Timber

class HomeEpoxyController: AsyncEpoxyController() {

    private var data = emptyList<HomeListItem>()

    init {
        Carousel.setDefaultGlobalSnapHelperFactory(null)
    }

    override fun buildModels() {
        Timber.d("Building")
        data.map { section ->
            when(section.type){
                ViewTypes.CAROUSEL -> {
                    val firstItem = section.item[0]
                    HeaderModel_()
                        .id(firstItem.id)
                        .recipe(firstItem)
                        .addTo(this)
                }

                ViewTypes.RECIPES -> {
                    // Add Title
                    LabelModel_()
                        .id(section.name)
                        .title(section.name)
                        .addTo(this)


                    val items = section.item.map {  recipe ->
                        RecipeModel_()
                            .id(recipe.id)
                            .recipe(recipe)

                    }

                    // Add carousel
                    CarouselModel_()
                        .id(section.name)
                        .models(items)
                        .padding(Carousel.Padding.dp(24,4,24,4,16))
                        .addTo(this)

                }
            }
        }
    }

    fun setSections(sections: List<HomeListItem>){
        this.data = sections
        requestModelBuild()
    }
}