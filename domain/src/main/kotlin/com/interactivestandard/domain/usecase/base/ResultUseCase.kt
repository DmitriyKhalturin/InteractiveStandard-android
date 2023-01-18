package com.interactivestandard.domain.usecase.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class ResultUseCase<R : Any> : UseCase<R>() {

    protected open suspend operator fun invoke(): UseCaseResult<R> {
        return withContext(Dispatchers.IO) {
            try {
                factory()
            } catch (e: Exception) {
                UseCaseResult.Failed(e)
            }
        }
    }

    protected abstract suspend fun factory(): UseCaseResult<R>
}
