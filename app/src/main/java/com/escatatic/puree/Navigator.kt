package com.escatatic.puree

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.escatatic.home.HomeNavigation
import javax.inject.Inject

class Navigator constructor(
    private val navController: NavController
): HomeNavigation {

    override fun openRecipeDetail(id: String) {
        navController.navigate(R.id.action_homeFragment_to_recipeDetailFragment, bundleOf(
            "recipeId" to id
        ))
    }

}