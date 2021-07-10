package com.escatatic.home.epoxy

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyControllerAdapter
import com.escatatic.core.extensions.dpToPx
import com.escatatic.home.epoxy.models.RecipeModel_
import timber.log.Timber

class MarginItemDecoration() : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val adapter = parent.adapter

        if (adapter is EpoxyControllerAdapter){
            val model = adapter.getModelAtPosition(position)
            Timber.d("${model::class.java.superclass}")

            val dp24 = view.context.dpToPx(24f)
            when(model::class.java){
                is CarouselModel_ -> {
                    when (position) {
                        0 -> {
                            Timber.d("first")
                            outRect.set(dp24,0,0,0)
                        }
                        (state.itemCount - 1) -> {
                            outRect.set(8,0,dp24,0)
                        }
                        else -> {
                            outRect.set(8,0,8,0)
                        }
                    }
                }
            }
        }else {
            Timber.d("No?")
            outRect.setEmpty()
        }

//        with(outRect) {
//            when (parent.getChildAdapterPosition(view)) {
//                0 -> {
//                    left = spaceSize
//                }
//                (state.itemCount - 1) -> {
//                    right = spaceSize
//                }
//                else -> {
//                    right = spaceSize / 2;
//                    left = spaceSize / 2
//                }
//            }
//            top = spaceSize
//            right = spaceSize
//            bottom = spaceSize
//        }
    }
}