package com.interactivestandard.domain.usecase

import com.interactivestandard.domain.model.Point
import com.interactivestandard.domain.repository.PointsRepository
import com.interactivestandard.domain.usecase.base.ResultUseCase
import kotlin.properties.Delegates

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 18.01.2023 19:23.
 */
class GetPointsUseCase(
    private val pointsRepository: PointsRepository,
) : ResultUseCase<List<Point>>() {

    private var count by Delegates.notNull<Int>()

    suspend operator fun invoke(count: Int): UseCaseResult<List<Point>> {
        this.count = count

        return invoke()
    }

    override suspend fun factory(): UseCaseResult<List<Point>> {
        val points = pointsRepository.getPoints(count)

        return successfulResult(points)
    }
}
