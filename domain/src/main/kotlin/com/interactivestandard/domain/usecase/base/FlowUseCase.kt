package com.interactivestandard.domain.usecase.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ProducerScope
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch

abstract class FlowUseCase<R : Any> : UseCase<R>() {

    protected operator fun invoke(): Flow<UseCaseResult<R>> = callbackFlow {
        val job = launch(Dispatchers.IO) {
            trySend(UseCaseResult.Suspended)

            try {
                factory()
            } catch (e: Exception) {
                trySend(UseCaseResult.Failed(e))
            }
        }

        awaitClose {
            job.cancel()
        }
    }

    context (ProducerScope<UseCaseResult<R>>)
    protected abstract suspend fun factory()
}
