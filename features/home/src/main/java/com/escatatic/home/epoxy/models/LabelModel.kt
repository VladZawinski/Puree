package com.escatatic.home.epoxy.models

import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.escatatic.home.R
import com.escatatic.home.databinding.ViewHolderLabelBinding

@EpoxyModelClass
abstract class LabelModel: DataBindingEpoxyModel() {

    @EpoxyAttribute
    lateinit var title: String

    override fun getDefaultLayout(): Int = R.layout.view_holder_label

    override fun setDataBindingVariables(binding: ViewDataBinding?) {
        (binding as ViewHolderLabelBinding).title = title
    }
}