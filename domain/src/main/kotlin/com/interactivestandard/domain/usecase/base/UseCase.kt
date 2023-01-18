package com.interactivestandard.domain.usecase.base

open class UseCase<T> {

    companion object {

        inline fun <T : Any> UseCaseResult<T>.use(block: (T) -> Unit) {
            when (this) {
                is UseCaseResult.Successful -> block(data)
                is UseCaseResult.Failed -> throw FailedResultException(exception)
                else -> Unit
            }
        }

        @Suppress("NOTHING_TO_INLINE")
        inline fun <T : Any> UseCaseResult<T>.extractResult(): T {
            return when (this) {
                is UseCaseResult.Successful -> data
                is UseCaseResult.Failed -> throw FailedResultException(exception)
                else -> throw IllegalResultException()
            }
        }

        class FailedResultException(exception: Exception) : Exception(exception)
        class IllegalResultException : Exception()

        val successfulResult: UseCaseResult<Unit> = UseCaseResult.Successful(Unit)
        inline fun <reified T: Any> successfulResult(result: T): UseCaseResult<T> = UseCaseResult.Successful(result)
    }

    sealed class UseCaseResult<out T : Any> {
        object Suspended : UseCaseResult<Nothing>()
        data class Successful<T : Any>(val data: T) : UseCaseResult<T>()
        data class Failed(val exception: Exception) : UseCaseResult<Nothing>()
    }
}
