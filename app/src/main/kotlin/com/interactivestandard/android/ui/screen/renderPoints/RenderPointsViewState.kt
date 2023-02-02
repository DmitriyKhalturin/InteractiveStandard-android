package com.interactivestandard.android.ui.screen.renderPoints

import com.interactivestandard.android.common.viewModel.ViewState
import com.interactivestandard.domain.model.Point

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 02.02.2023 2:36.
 */
sealed class RenderPointsViewState : ViewState {
    object Init : RenderPointsViewState()
    object PointsLoading : RenderPointsViewState()
    data class Points(val points: List<Point>) : RenderPointsViewState()
    object OperationFailed : RenderPointsViewState()
}
