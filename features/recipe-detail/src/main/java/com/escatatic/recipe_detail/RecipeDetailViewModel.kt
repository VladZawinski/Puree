package com.escatatic.recipe_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.escatatic.domain.repositories.RecipeDetailRepository
import com.escatatic.recipe_detail.viewstates.RecipeDetailSideEffect
import com.escatatic.recipe_detail.viewstates.RecipeDetailViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private val repo: RecipeDetailRepository
): ContainerHost<RecipeDetailViewState,RecipeDetailSideEffect>, ViewModel(){

    override val container: Container<RecipeDetailViewState, RecipeDetailSideEffect>
        = container(RecipeDetailViewState())

    fun fetch(id: String) {
       viewModelScope.launch {
          try {
              repo.fetchDetail(id)
          }catch (e: Throwable){
              Timber.d(e)
          }
       }
    }

}