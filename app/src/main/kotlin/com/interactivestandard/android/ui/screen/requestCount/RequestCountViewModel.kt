package com.interactivestandard.android.ui.screen.requestCount

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.interactivestandard.android.common.viewModel.BaseViewModel
import com.interactivestandard.android.ui.navigation.NavigationService
import com.interactivestandard.android.ui.navigation.destination.RenderPointsDestination
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 02.02.2023 2:35.
 */
class RequestCountViewModel : BaseViewModel<RequestCountViewState>(), KoinComponent {

    private val navigationService: NavigationService by inject()

    override var uiState by mutableStateOf(RequestCountViewState())

    fun updateCount(value: String) {
        uiState = uiState.copy(
            count = value,
            isError = false,
        )
    }

    fun renderChart() {
        val count = uiState.count.toIntOrNull()

        if (count == null) {
            uiState = uiState.copy(isError = true)
        } else {
            val destination = RenderPointsDestination.buildDestinationRoute(count)

            navigationService.navigate(destination)
        }
    }
}
