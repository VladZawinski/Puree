package com.escatatic.home.epoxy.models

import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.escatatic.home.R
import com.escatatic.home.databinding.ViewHolderCarouselBinding

@EpoxyModelClass
abstract class CarouselModel: DataBindingEpoxyModel(){

    override fun getDefaultLayout(): Int = R.layout.view_holder_carousel

    override fun setDataBindingVariables(binding: ViewDataBinding?) {
        binding as ViewHolderCarouselBinding
    }
}