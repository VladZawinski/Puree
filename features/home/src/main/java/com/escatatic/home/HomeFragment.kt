package com.escatatic.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.escatatic.core.base.ViewBindingFragment
import com.escatatic.home.databinding.FragmentHomeBinding
import com.escatatic.home.epoxy.MarginItemDecoration
import com.escatatic.home.epoxy.controllers.HomeEpoxyController
import com.escatatic.home.viewstates.HomeSideEffect
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber


class HomeFragment(
    override val layoutRes: Int = R.layout.fragment_home
) : ViewBindingFragment<FragmentHomeBinding>(){

    private val viewModel by viewModels<HomeViewModel>()

    private val sectionController = HomeEpoxyController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }

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
}