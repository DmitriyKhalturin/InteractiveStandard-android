package com.interactivestandard.android.ui.screen.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.interactivestandard.android.ui.screen.main.composable.ErrorDialog
import com.interactivestandard.android.ui.screen.main.composable.PointsChart
import com.interactivestandard.android.ui.screen.main.composable.PointsCountInput
import com.interactivestandard.android.ui.screen.main.composable.PointsTable
import com.interactivestandard.android.ui.screen.main.model.MainViewState
import com.interactivestandard.android.ui.screen.main.stub.stubPoints
import com.interactivestandard.android.ui.theme.InteractiveStandardTheme
import org.koin.androidx.compose.koinViewModel

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 19.01.2023 23:28.
 */
@Composable
fun MainScreen(viewModel: MainViewModel = koinViewModel()) {
    val uiState = viewModel.uiState

    if (uiState.error is MainViewState.ErrorState.RequestGerPointsFailed) {
        ErrorDialog(onDismissRequest = viewModel::clearErrorFlag)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val configuration = LocalConfiguration.current

        PointsCountInput(
            modifier = Modifier.fillMaxWidth(),
            value = uiState.count,
            onValueChange = viewModel::updateCount,
            onClick = viewModel::renderChart,
            singleLine = configuration.orientation != Configuration.ORIENTATION_PORTRAIT,
            isError = uiState.error is MainViewState.ErrorState.EnterInvalidCountValue,
        )

        when (configuration.orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                PointsTable(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(top = 16.dp),
                    points = uiState.points,
                )

                PointsChart(
                    modifier = Modifier
                        .weight(1f)
                        .padding(top = 16.dp),
                    points = uiState.points,
                )
            }
            Configuration.ORIENTATION_LANDSCAPE -> {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 8.dp)
                ) {
                    PointsTable(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        points = uiState.points,
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    PointsChart(
                        modifier = Modifier.weight(1f),
                        points = uiState.points,
                    )
                }
            }
            else -> throw IllegalStateException("Screen orientation - undefined.")
        }
    }
}


@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun MainScreen_NoPoints_Preview() {
    InteractiveStandardTheme {
        val viewModel = MainViewModel()

        MainScreen(viewModel)
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun MainScreen_HasPoints_Preview() {
    InteractiveStandardTheme {
        val viewModel = MainViewModel().apply {
            setUiState(
                uiState.copy(
                    count = "3",
                    points = stubPoints,
                )
            )
        }

        MainScreen(viewModel)
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun MainScreen_HasError_Preview() {
    InteractiveStandardTheme {
        val viewModel = MainViewModel().apply {
            setUiState(
                uiState.copy(
                    error = MainViewState.ErrorState.RequestGerPointsFailed,
                )
            )
        }

        MainScreen(viewModel)
    }
}
