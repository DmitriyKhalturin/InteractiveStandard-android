package com.interactivestandard.android.ui.screen.renderPoints

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import com.interactivestandard.android.R
import com.interactivestandard.android.ui.screen.renderPoints.composable.PointsChart
import com.interactivestandard.android.ui.screen.renderPoints.composable.PointsTable
import com.interactivestandard.android.ui.screen.renderPoints.stub.stubPoints
import com.interactivestandard.android.ui.theme.InteractiveStandardTheme
import com.interactivestandard.domain.model.Point
import org.koin.androidx.compose.koinViewModel

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 02.02.2023 1:16.
 */
@Composable
fun RenderPointsScreen(viewModel: RenderPointsViewModel = koinViewModel()) {
    /** It worked before. But not now.
     * LaunchedEffect(viewModel) {
     *     viewModel.requestPoints()
     * }
     */

    when (val uiState = viewModel.uiState) {
        RenderPointsViewState.Init -> Unit
        RenderPointsViewState.PointsLoading -> PointsLoadingView()
        is RenderPointsViewState.Points -> PointsView(points = uiState.points)
        RenderPointsViewState.OperationFailed -> OperationFailedView(requestPointsAgain = viewModel::requestPoints)
    }
}

@Composable
private fun PointsLoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            CircularProgressIndicator()

            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = stringResource(id = R.string.renderPoints_loading),
            )
        }
    }
}

@Composable
private fun PointsView(points: List<Point>) {
    val configuration = LocalConfiguration.current

    when (configuration.orientation) {
        Configuration.ORIENTATION_PORTRAIT -> {
            Column(modifier = Modifier.fillMaxSize()) {
                PointsTable(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    points = points,
                )

                Spacer(modifier = Modifier.height(16.dp))

                PointsChart(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    points = points,
                )
            }
        }
        Configuration.ORIENTATION_LANDSCAPE -> {
            Row(modifier = Modifier.fillMaxSize()) {
                PointsTable(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    points = points,
                )

                Spacer(modifier = Modifier.width(16.dp))

                PointsChart(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    points = points,
                )
            }
        }
        else -> throw IllegalStateException("Screen orientation - undefined.")
    }
}

@Composable
private fun OperationFailedView(requestPointsAgain: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier
                    .size(64.dp)
                    .padding(bottom = 8.dp),
                imageVector = Icons.Outlined.Warning,
                contentDescription = null,
                tint = MaterialTheme.colors.error,
            )

            Text(text = stringResource(id = R.string.renderPoints_operationFailed))

            Button(
                modifier = Modifier.padding(top = 32.dp),
                onClick = requestPointsAgain,
            ) {
                Text(text = stringResource(id = R.string.button__retry))
            }
        }
    }
}


@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun RenderPointsScreen_PointsLoading_Preview() {
    InteractiveStandardTheme {
        val viewModel = RenderPointsViewModel(SavedStateHandle()).apply {
            setUiState(RenderPointsViewState.PointsLoading)
        }

        RenderPointsScreen(viewModel)
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun RenderPointsScreen_Points_Preview() {
    InteractiveStandardTheme {
        val viewModel = RenderPointsViewModel(SavedStateHandle()).apply {
            setUiState(RenderPointsViewState.Points(stubPoints))
        }

        RenderPointsScreen(viewModel)
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun RenderPointsScreen_OperationFailed_Preview() {
    InteractiveStandardTheme {
        val viewModel = RenderPointsViewModel(SavedStateHandle()).apply {
            setUiState(RenderPointsViewState.OperationFailed)
        }

        RenderPointsScreen(viewModel)
    }
}
