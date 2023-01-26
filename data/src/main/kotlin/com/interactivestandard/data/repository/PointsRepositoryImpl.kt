package com.interactivestandard.data.repository

import com.interactivestandard.data.api.ApiClient
import com.interactivestandard.domain.model.Point
import com.interactivestandard.domain.repository.PointsRepository

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 18.01.2023 22:38.
 */
class PointsRepositoryImpl(
    private val apiClient: ApiClient,
) : PointsRepository {

    override suspend fun getPoints(count: Int?): List<Point> {
        val points = apiClient.pointService.getPoints(count)

        return points.map { Point(it.x, it.y) }
    }
}
