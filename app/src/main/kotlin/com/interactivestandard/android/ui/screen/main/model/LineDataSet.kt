package com.interactivestandard.android.ui.screen.main.model

import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.interactivestandard.domain.model.Point

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 23.01.2023 20:36.
 */

fun List<Point>.toLineDataSet(): LineData {
    val linePoints = map { Entry(it.x.toFloat(), it.y.toFloat()) }
    val lineDataSet = LineDataSet(linePoints, null).apply {
        axisDependency = YAxis.AxisDependency.LEFT
        mode = LineDataSet.Mode.CUBIC_BEZIER
    }

    return LineData(lineDataSet)
}
