package com.escatatic.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar

abstract class ViewBindingFragment<VB: ViewDataBinding?>: BaseFragment() {

    private var _viewBinding: VB? = null
    val viewBinding get() = _viewBinding

    @get:LayoutRes
    abstract val layoutRes: Int


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = DataBindingUtil.inflate<VB>(inflater,layoutRes,container,false)
        return viewBinding?.root
    }

    fun showSnackBar(message: String,root: View){
        Snackbar.make(_viewBinding?.root!!,message, Snackbar.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

}