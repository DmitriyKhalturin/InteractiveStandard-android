package com.interactivestandard.android.ui.screen.main.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.interactivestandard.android.R

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 24.01.2023 17:16.
 */
@Composable
fun ErrorDialog(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            elevation = 1.dp,
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = stringResource(id = R.string.errorMessage__requestGetPointsFailed),
            )
        }
    }
}
