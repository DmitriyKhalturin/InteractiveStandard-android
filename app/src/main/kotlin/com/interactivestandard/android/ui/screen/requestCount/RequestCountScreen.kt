package com.interactivestandard.android.ui.screen.requestCount

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.interactivestandard.android.R
import com.interactivestandard.android.ui.theme.InteractiveStandardTheme
import org.koin.androidx.compose.koinViewModel

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 02.02.2023 1:16.
 */
@Composable
fun RequestCountScreen(viewModel: RequestCountViewModel = koinViewModel()) {
    val uiState = viewModel.uiState

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            modifier = Modifier.widthIn(max = 260.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.count,
                onValueChange = viewModel::updateCount,
                label = {
                    Text(text = stringResource(id = R.string.textField_label__count))
                },
                isError = uiState.isError,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = viewModel::renderChart,
            ) {
                Text(text = stringResource(id = R.string.button__go))
            }
        }
    }
}


@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun RequestCountScreen_Preview() {
    InteractiveStandardTheme {
        val viewModel = RequestCountViewModel()

        RequestCountScreen(viewModel)
    }
}
