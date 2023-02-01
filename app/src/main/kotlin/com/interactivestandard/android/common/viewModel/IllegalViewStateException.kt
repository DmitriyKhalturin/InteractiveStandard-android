package com.interactivestandard.android.common.viewModel

class IllegalViewStateException(uiState: ViewState) : Exception("Illegal ViewState: $uiState")
