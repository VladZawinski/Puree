package com.escatatic.home

import androidx.lifecycle.ViewModel
import com.escatatic.domain.repositories.HomeRepository
import com.escatatic.home.viewstates.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.uniflow.android.AndroidDataFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(private val repo: HomeRepository): AndroidDataFlow(defaultState = HomeViewState()){

    init {
        prefetch()
    }

    private fun prefetch() = action(
        onAction = {
            val result = repo.fetchHomeSection()
            setState { (it as HomeViewState).copy(sections = result) }
        },
        onError = { error, _ ->
            Timber.e(error)
        }
    )

}