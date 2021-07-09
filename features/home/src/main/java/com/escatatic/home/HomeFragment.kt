package com.escatatic.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.escatatic.core.base.ViewBindingFragment
import com.escatatic.home.databinding.FragmentHomeBinding
import com.escatatic.home.viewstates.HomeViewState
import io.uniflow.android.livedata.onStates
import timber.log.Timber


class HomeFragment(
    override val layoutRes: Int = R.layout.fragment_home
) : ViewBindingFragment<FragmentHomeBinding>(){

    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onStates(viewModel){
            when(it){
                is HomeViewState -> {
                    Timber.d(it.sections.toString())
                }
            }
        }
    }
}