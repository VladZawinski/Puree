package com.escatatic.home

import androidx.lifecycle.ViewModel
import com.escatatic.domain.repositories.HomeRepository
import com.escatatic.home.viewstates.HomeSideEffect
import com.escatatic.home.viewstates.HomeViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import io.uniflow.android.AndroidDataFlow
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val repo: HomeRepository
): ContainerHost<HomeViewState,HomeSideEffect>, ViewModel(){

    override val container: Container<HomeViewState, HomeSideEffect> = container(HomeViewState()){
        prefetch()
    }

    private fun prefetch() = intent {
        postSideEffect(HomeSideEffect.Loading)
        val result = repo.fetchHomeSection()
        reduce {
            state.copy(sections = result)
        }
    }

//    private fun prefetch() = action(
//        onAction = {
//            val result = repo.fetchHomeSection()
//            setState { (it as HomeViewState).copy(sections = result) }
//        },
//        onError = { error, _ ->
//            Timber.e(error)
//        }
//    )

//    override val container: Container<HomeViewState, HomeSideEffect>

}