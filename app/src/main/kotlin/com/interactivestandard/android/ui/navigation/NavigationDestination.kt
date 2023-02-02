package com.interactivestandard.android.ui.navigation

import androidx.navigation.NamedNavArgument

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 02.02.2023 3:09.
 */
interface NavigationDestination {
    val route: String
    val arguments: List<NamedNavArgument>

    /**
     * Inside implementation this interface:
     * 1. Builder destination route for navigation.
     * 2. Function extractor arguments from destination route.
     */
}
