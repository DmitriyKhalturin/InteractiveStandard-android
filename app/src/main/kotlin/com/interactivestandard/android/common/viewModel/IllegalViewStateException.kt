package com.interactivestandard.android.common.viewModel

/**
 * Created by Dmitriy Khalturin <dmitry.halturin.86@gmail.com>
 * for InteractiveStandard on 24.01.2023 16:38.
 */
class IllegalViewStateException(uiState: ViewState) : Exception("Illegal ViewState: $uiState")
