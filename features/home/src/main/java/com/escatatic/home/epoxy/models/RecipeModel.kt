package com.escatatic.home.epoxy.models

import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.escatatic.domain.models.home.Recipe
import com.escatatic.home.R
import com.escatatic.home.databinding.ViewHolderRecipeBinding

@EpoxyModelClass
abstract class RecipeModel: DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var recipe: Recipe

    override fun getDefaultLayout(): Int = R.layout.view_holder_recipe

    override fun setDataBindingVariables(binding: ViewDataBinding?) {
        (binding as ViewHolderRecipeBinding).recipe = recipe
    }
}