package com.interactivestandard.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.interactivestandard.android.ui.navigation.destination.RenderPointsDestination
import com.interactivestandard.android.ui.navigation.destination.RequestCountDestination
import com.interactivestandard.android.ui.screen.renderPoints.RenderPointsScreen
import com.interactivestandard.android.ui.screen.requestCount.RequestCountScreen

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 02.02.2023 1:20.
 */
@Composable
fun MainNavigationGraph(
    modifier: Modifier,
    navigationController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navigationController,
        startDestination = RequestCountDestination.route,
    ) {
        composable(navigationDestination = RequestCountDestination) {
            RequestCountScreen()
        }

        composable(navigationDestination = RenderPointsDestination) {
            RenderPointsScreen()
        }
    }
}
