package com.interactivestandard.android.ui.screen.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.interactivestandard.android.common.viewModel.BaseViewModel
import com.interactivestandard.android.ui.screen.main.model.MainViewState
import com.interactivestandard.domain.usecase.GetPointsUseCase
import com.interactivestandard.domain.usecase.base.UseCase
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 19.01.2023 23:29.
 */
class MainViewModel : BaseViewModel<MainViewState>(), KoinComponent {

    private val getPointsUseCase: GetPointsUseCase by inject()

    override var uiState by mutableStateOf(MainViewState())

    fun updateCount(value: String) {
        uiState = uiState.copy(
            count = value,
            error = null,
        )
    }

    fun renderChart() {
        viewModelScope.launch {
            val count = uiState.count.toIntOrNull()

            uiState = if (count != null) {
                when (val result = getPointsUseCase(count)) {
                    is UseCase.UseCaseResult.Successful -> uiState.copy(points = result.data)
                    is UseCase.UseCaseResult.Failed -> result.handleGetPointsRequest()
                    else -> uiState
                }
            } else {
                uiState.copy(error = MainViewState.ErrorState.EnterInvalidCountValue)
            }
        }
    }

    private fun UseCase.UseCaseResult.Failed.handleGetPointsRequest(): MainViewState {
        onExceptionHandler(exception)

        return uiState.copy(
            points = emptyList(),
            error = MainViewState.ErrorState.RequestGerPointsFailed,
        )
    }

    fun clearErrorFlag() {
        uiState = uiState.copy(error = null)
    }
}
