package com.interactivestandard.android.ui.screen.renderPoints.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.interactivestandard.android.R
import com.interactivestandard.android.ui.screen.renderPoints.stub.stubPoints
import com.interactivestandard.android.ui.theme.InteractiveStandardTheme
import com.interactivestandard.domain.model.Point

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 25.01.2023 21:52.
 */
@Composable
fun PointsTable(
    modifier: Modifier = Modifier,
    points: List<Point>,
) {
    Column(modifier = modifier) {
        if (points.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = stringResource(id = R.string.pointsTable_noPoints))
            }
        } else {
            TableItem(
                index = stringResource(id = R.string.pointsTable_indexColumn),
                x = stringResource(id = R.string.pointsTable_xColumn),
                y = stringResource(id = R.string.pointsTable_yColumn),
            )

            LazyColumn(
                modifier = Modifier,
                state = rememberLazyListState(),
            ) {
                itemsIndexed(points) { index, item ->
                    TableItem(
                        index = (index + 1).toString(),
                        x = item.x.toString(),
                        y = item.y.toString(),
                    )
                }
            }
        }
    }
}

@Composable
private fun TableItem(index: String, x: String, y: String) {
    Row(modifier = Modifier.fillMaxWidth()) {
        val modifier = Modifier
            .weight(1f)
            .padding(4.dp)

        Text(modifier = modifier, text = index, textAlign = TextAlign.Center)
        Text(modifier = modifier, text = x, textAlign = TextAlign.Center)
        Text(modifier = modifier, text = y, textAlign = TextAlign.Center)
    }
}


@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun PointsTable_NoPoints_Preview() {
    InteractiveStandardTheme {
        PointsTable(
            modifier = Modifier.fillMaxSize(),
            points = emptyList(),
        )
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun PointsTable_WithStubPoints_Preview() {
    InteractiveStandardTheme {
        PointsTable(
            modifier = Modifier.fillMaxSize(),
            points = stubPoints,
        )
    }
}
