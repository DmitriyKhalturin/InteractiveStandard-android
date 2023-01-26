package com.interactivestandard.android.ui.screen.main.model

import com.interactivestandard.android.common.viewModel.ViewState
import com.interactivestandard.domain.model.Point

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 20.01.2023 20:18.
 */
data class MainViewState(
    val count: String = "",
    val points: List<Point> = emptyList(),
    val error: ErrorState? = null,
) : ViewState {
    sealed class ErrorState {
        object EnterInvalidCountValue : ErrorState()
        object RequestGerPointsFailed : ErrorState()
    }
}
