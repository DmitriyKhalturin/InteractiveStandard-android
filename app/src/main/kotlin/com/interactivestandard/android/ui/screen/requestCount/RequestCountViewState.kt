package com.interactivestandard.android.ui.screen.requestCount

import com.interactivestandard.android.common.viewModel.ViewState

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 02.02.2023 2:37.
 */
data class RequestCountViewState(
    val count: String = "",
    val isError: Boolean = false,
) : ViewState
