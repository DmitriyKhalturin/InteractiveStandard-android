package com.interactivestandard.data.api.service

import com.interactivestandard.data.api.ApiClient
import com.interactivestandard.data.api.dto.GetPointsResponse
import com.interactivestandard.data.api.dto.PointDto
import io.ktor.client.call.*
import io.ktor.client.request.*

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 18.01.2023 23:49.
 */
class PointService(
    private val apiClient: ApiClient,
) {

    @Throws(NoTransformationFoundException::class)
    internal suspend fun getPoints(count: Int? = null): List<PointDto> {
        val response = apiClient.instance.get("/api/test/points") {
            if (count != null) {
                parameter("count", "$count")
            }
        }
        // TODO: handle response status.
        val body: GetPointsResponse = response.body()

        return body.points
    }
}
