package com.interactivestandard.android.ui.screen.main.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
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

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 25.01.2023 22:00.
 */
@Composable
fun PointsCountInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    onClick: () -> Unit,
    singleLine: Boolean,
    isError: Boolean,
) {
    val errorText = if (isError) stringResource(id = R.string.fieldError__wrongPointsCount) else ""

    if (singleLine) {
        Column(modifier = modifier) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                OutlinedTextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 16.dp),
                    value = value,
                    onValueChange = onValueChange,
                    label = {
                        Text(text = stringResource(id = R.string.fieldLabel__count))
                    },
                    isError = isError,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                    ),
                    singleLine = true,
                )

                Button(
                    onClick = onClick,
                ) {
                    Text(text = stringResource(id = R.string.button__renderChart))
                }
            }

            Text(
                text = errorText,
                color = MaterialTheme.colors.error,
            )
        }
    } else {
        Column(modifier = modifier) {
            Column(modifier = Modifier.padding(bottom = 4.dp)) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = value,
                    onValueChange = onValueChange,
                    label = {
                        Text(text = stringResource(id = R.string.fieldLabel__count))
                    },
                    isError = isError,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                    ),
                    singleLine = true,
                )

                Text(
                    modifier = Modifier.align(Alignment.End),
                    text = errorText,
                    color = MaterialTheme.colors.error,
                )
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onClick,
            ) {
                Text(text = stringResource(id = R.string.button__renderChart))
            }
        }
    }
}


@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun PointsCountInput_NoSingleLine_Preview() {
    InteractiveStandardTheme {
        PointsCountInput(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            onClick = {},
            singleLine = false,
            isError = true,
        )
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun PointsCountInput_SingleLine_Preview() {
    InteractiveStandardTheme {
        PointsCountInput(
            modifier = Modifier.fillMaxWidth(),
            value = "3",
            onValueChange = {},
            onClick = {},
            singleLine = true,
            isError = false,
        )
    }
}
