package com.interactivestandard.data.api.dto

import kotlinx.serialization.Serializable

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 19.01.2023 0:24.
 */
@Serializable
internal data class PointDto(
    val x: Double,
    val y: Double,
)
