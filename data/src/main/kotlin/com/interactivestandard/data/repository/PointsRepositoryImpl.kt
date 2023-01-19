package com.interactivestandard.data.repository

import com.interactivestandard.data.api.service.PointsApiService
import com.interactivestandard.domain.model.Point
import com.interactivestandard.domain.repository.PointsRepository

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 18.01.2023 22:38.
 */
class PointsRepositoryImpl(
    private val pointsApiService: PointsApiService,
) : PointsRepository {

    override suspend fun getPoints(count: Int?): List<Point> {
        return pointsApiService.getPoints(count)
            .map { Point(it.x, it.y) }
    }
}
