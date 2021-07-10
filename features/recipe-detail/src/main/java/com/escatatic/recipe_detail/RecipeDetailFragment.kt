package com.escatatic.recipe_detail

import android.os.Bundle
import android.view.View
import com.escatatic.core.base.BundleKeys
import com.escatatic.core.base.ViewBindingFragment
import com.escatatic.recipe_detail.databinding.FragmentRecipeDetailBinding
import timber.log.Timber

class RecipeDetailFragment(
    override val layoutRes: Int = R.layout.fragment_recipe_detail
    ) : ViewBindingFragment<FragmentRecipeDetailBinding>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recipeId = arguments?.getString(BundleKeys.BUNDLE_RECIPE_ID,"")
        Timber.d("$recipeId")
    }
}