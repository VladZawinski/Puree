package com.escatatic.home.epoxy.models

import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.escatatic.domain.models.home.Recipe
import com.escatatic.home.R
import com.escatatic.home.databinding.ViewHolderRecipeBinding
import com.escatatic.home.epoxy.listeners.OnRecipeItemClickListener

@EpoxyModelClass
abstract class RecipeModel: DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var recipe: Recipe

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var onRecipeClick: OnRecipeItemClickListener

    override fun getDefaultLayout(): Int = R.layout.view_holder_recipe

    override fun setDataBindingVariables(binding: ViewDataBinding?) {
        (binding as ViewHolderRecipeBinding).recipe = recipe
        binding.root.setOnClickListener { onRecipeClick.onRecipeClick(recipeId = recipe.id) }
    }
}