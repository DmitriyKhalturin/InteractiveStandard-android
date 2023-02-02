package com.interactivestandard.android.component

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.interactivestandard.android.ui.navigation.MainNavigationGraph
import com.interactivestandard.android.ui.navigation.NavigationService
import com.interactivestandard.android.ui.theme.InteractiveStandardTheme
import org.koin.android.ext.android.inject

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 19.01.2023 23:29.
 */
class MainActivity : ComponentActivity() {

    private val navigationService: NavigationService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navigationController = rememberNavController()

            navigationService.inject(navigationController)

            InteractiveStandardTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    // TODO: add topBar
                ) { innerPadding ->
                    MainNavigationGraph(
                        modifier = Modifier.padding(innerPadding),
                        navigationController = navigationController,
                    )
                }
            }
        }
    }
}
