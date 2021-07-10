package com.escatatic.core.extensions

import android.content.Context
import android.util.DisplayMetrics
import java.lang.Math.round

fun Context.dpToPx(dp: Float): Int {
    return round(dp * (resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)).toInt()
}