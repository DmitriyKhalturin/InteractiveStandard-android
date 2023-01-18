package com.interactivestandard.domain.repository

import com.interactivestandard.domain.model.Point

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 18.01.2023 19:42.
 */
interface PointsRepository {
    suspend fun getPoints(count: Int): List<Point>
}
