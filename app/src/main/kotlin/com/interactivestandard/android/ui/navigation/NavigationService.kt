package com.interactivestandard.android.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.Navigator

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 02.02.2023 20:42.
 */
class NavigationService {

    private lateinit var controller: NavController

    fun inject(controller: NavController) {
        this.controller = controller
    }

    fun navigate(route: String, navOptions: NavOptions? = null, navigatorExtras: Navigator.Extras? = null) {
        controller.navigate(route, navOptions, navigatorExtras)
    }

    fun navigate(route: String, builder: NavOptionsBuilder.() -> Unit) {
        controller.navigate(route, builder)
    }

    // TODO: implement any required methods later.
}
