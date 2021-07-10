package com.escatatic.recipe_detail

import androidx.lifecycle.ViewModel
import com.escatatic.recipe_detail.viewstates.RecipeDetailSideEffect
import com.escatatic.recipe_detail.viewstates.RecipeDetailViewState
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class RecipeDetailViewModel @Inject constructor(

): ContainerHost<RecipeDetailViewState,RecipeDetailSideEffect>, ViewModel(){

    override val container: Container<RecipeDetailViewState, RecipeDetailSideEffect>
        = container(RecipeDetailViewState())

}