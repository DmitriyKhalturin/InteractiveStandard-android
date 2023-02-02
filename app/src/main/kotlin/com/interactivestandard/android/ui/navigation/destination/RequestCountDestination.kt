package com.interactivestandard.android.ui.navigation.destination

import androidx.navigation.NamedNavArgument
import com.interactivestandard.android.ui.navigation.NavigationDestination

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 02.02.2023 3:12.
 */
object RequestCountDestination : NavigationDestination {
    override val route = "requestCount"
    override val arguments: List<NamedNavArgument> = emptyList()
}
