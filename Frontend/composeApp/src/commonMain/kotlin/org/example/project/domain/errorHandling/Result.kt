package org.example.project.domain.errorHandling

typealias RootError = Error

sealed interface Result<out D, out E: RootError> {
    data class Success<out D, out E: RootError>(val data: D): Result<D, E>
    data class Error<out D, out E: RootError>(val error: E): Result<D, E>
}

inline fun <R, D, E: RootError> Result<D, E>.fold(
    onSuccess: (value: D) -> R,
    onFailure: (exception: E) -> R
): R {
    return when(this){
        is Result.Success -> onSuccess(data)
        is Result.Error -> onFailure(error)
    }
}