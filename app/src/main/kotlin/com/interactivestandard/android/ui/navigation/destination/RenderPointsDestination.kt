package com.interactivestandard.android.ui.navigation.destination

import androidx.lifecycle.SavedStateHandle
import com.interactivestandard.android.ui.navigation.NavigationDestination
import com.interactivestandard.android.ui.navigation.buildIntegerArgument

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 02.02.2023 3:13.
 */
object RenderPointsDestination : NavigationDestination {

    private const val countArgumentName = "count"

    override val route = "renderPoints/{$countArgumentName}"
    override val arguments = listOf(countArgumentName.buildIntegerArgument())

    fun buildDestinationRoute(count: Int): String {
        return "renderPoints/$count"
    }

    val SavedStateHandle.argumentCount: Int
        get() = checkNotNull(this[countArgumentName])
}
