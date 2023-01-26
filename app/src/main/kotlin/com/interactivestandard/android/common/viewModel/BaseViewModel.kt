package com.interactivestandard.android.common.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

abstract class BaseViewModel<VS: ViewState> : ViewModel() {

    abstract var uiState: VS
        protected set

    @JvmName("updateUiState")
    fun setUiState(value: VS) {
        uiState = value
    }

    protected inline fun <reified VS> castViewState(block: (VS) -> Unit) {
        val currentViewState = uiState

        if (currentViewState is VS) block(currentViewState) else throw IllegalViewStateException(currentViewState)
    }


    private val supervisor = SupervisorJob()

    private val exceptionHandler = CoroutineExceptionHandler { _, e ->
        onExceptionHandler(e)
    }

    open fun onExceptionHandler(e: Throwable) {
        e.printStackTrace()
    }

    private val coroutineContext = (supervisor + exceptionHandler)

    protected fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(context = coroutineContext, block = block)
    }

    protected fun <T> async(block: suspend CoroutineScope.() -> T): Deferred<T> {
        return viewModelScope.async(context = coroutineContext, block = block)
    }
}
