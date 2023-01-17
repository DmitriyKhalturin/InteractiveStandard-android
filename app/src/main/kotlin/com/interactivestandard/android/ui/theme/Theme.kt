package com.interactivestandard.android.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun InteractiveStandardTheme(
    inDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (inDarkTheme) darkColors() else lightColors()
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            val insetController = WindowCompat.getInsetsController(window, view)

            window.statusBarColor = colorScheme.primary.toArgb()
            insetController.isAppearanceLightStatusBars = inDarkTheme
        }
    }

    MaterialTheme(
        colors = colorScheme,
        content = content,
    )
}
