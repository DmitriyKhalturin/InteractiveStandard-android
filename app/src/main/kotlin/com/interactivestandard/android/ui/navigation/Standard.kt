package com.interactivestandard.android.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.composable

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 02.02.2023 15:17.
 */
fun String.buildIntegerArgument(builder: NavArgumentBuilder.() -> Unit = {}): NamedNavArgument {
    return navArgument(this) {
        builder()
        type = NavType.IntType
    }
}

fun NavGraphBuilder.composable(
    navigationDestination: NavigationDestination,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navigationDestination.route,
        arguments = navigationDestination.arguments,
        content = content,
    )
}
