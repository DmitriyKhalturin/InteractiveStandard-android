package com.interactivestandard.android.ui.screen.renderPoints

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.interactivestandard.android.common.viewModel.BaseViewModel
import com.interactivestandard.android.ui.navigation.destination.RenderPointsDestination.argumentCount
import com.interactivestandard.domain.usecase.GetPointsUseCase
import com.interactivestandard.domain.usecase.base.UseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 02.02.2023 2:35.
 */
class RenderPointsViewModel(savedStateHandle: SavedStateHandle) : BaseViewModel<RenderPointsViewState>(), KoinComponent {

    private val count: Int by lazy { savedStateHandle.argumentCount }

    private val getPointsUseCase: GetPointsUseCase by inject()

    override var uiState by mutableStateOf<RenderPointsViewState>(RenderPointsViewState.Init)

    fun requestPoints() {
        if (uiState !is RenderPointsViewState.PointsLoading) {
            viewModelScope.launch {
                uiState = when (val result = getPointsUseCase(count)) {
                    is UseCase.UseCaseResult.Suspended -> RenderPointsViewState.PointsLoading
                    is UseCase.UseCaseResult.Successful -> RenderPointsViewState.Points(points = result.data)
                    is UseCase.UseCaseResult.Failed -> RenderPointsViewState.OperationFailed
                }
            }
        }
    }
}
