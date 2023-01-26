package com.interactivestandard.android.ui.screen.main.composable

import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.interactivestandard.android.ui.screen.main.model.toLineDataSet
import com.interactivestandard.android.ui.screen.main.stub.stubPoints
import com.interactivestandard.android.ui.theme.InteractiveStandardTheme
import com.interactivestandard.domain.model.Point

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 24.01.2023 17:17.
 */
@Composable
fun PointsChart(
    modifier: Modifier = Modifier,
    points: List<Point>,
) {
    AndroidView(
        modifier = modifier,
        factory = {
            LineChart(it).apply {
                layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

                description.apply {
                    isEnabled = false
                }

                legend.apply {
                    isEnabled = false
                }
            }
        },
        update = {
            it.data = points.toLineDataSet()
            it.invalidate()
        },
    )
}


@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun PointsChartPreview() {
    InteractiveStandardTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {
            PointsChart(points = stubPoints)
        }
    }
}
