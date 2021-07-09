package com.escatatic.home.viewstates

import com.escatatic.domain.models.home.HomeListItem
import io.uniflow.core.flow.data.UIState

data class HomeViewState(
    val sections: List<HomeListItem> = emptyList()
): UIState()