package com.interactivestandard.android.common.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

open class BaseViewModel : ViewModel() {

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
