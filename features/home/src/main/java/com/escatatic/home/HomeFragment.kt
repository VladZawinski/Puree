package com.escatatic.home

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.escatatic.core.base.BundleKeys
import com.escatatic.core.base.ViewBindingFragment
import com.escatatic.home.databinding.FragmentHomeBinding
import com.escatatic.home.epoxy.MarginItemDecoration
import com.escatatic.home.epoxy.controllers.HomeEpoxyController
import com.escatatic.home.epoxy.listeners.OnRecipeItemClickListener
import com.escatatic.home.viewstates.HomeSideEffect
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


class HomeFragment(
    override val layoutRes: Int = R.layout.fragment_home
) : ViewBindingFragment<FragmentHomeBinding>(), OnRecipeItemClickListener{

    private val viewModel by viewModels<HomeViewModel>()

    private val sectionController = HomeEpoxyController(this)

    @InternalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding?.sectionRV?.apply {
            adapter = sectionController.adapter
            addItemDecoration(MarginItemDecoration())
        }

        lifecycleScope.launchWhenCreated {
            viewModel.container.stateFlow.collect { state ->
                sectionController.setSections(state.sections)

            }
        }

        lifecycleScope.launch {
            viewModel.container.sideEffectFlow
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    when(it){
                        is HomeSideEffect.Loading -> {
                            Timber.d("Loading")
                        }
                    }
                }
        }

    }

    override fun onRecipeClick(recipeId: String) {
        findNavController().navigate(
            R.id.action_homeFragment_to_recipeDetailFragment,
            bundleOf(BundleKeys.BUNDLE_RECIPE_ID to recipeId)
        )
    }
}