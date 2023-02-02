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
import com.interactivestandard.android.ui.theme.InteractiveStandardTheme

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 19.01.2023 23:29.
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navigationController = rememberNavController()

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
