package com.example.codingchallengespacex.core.utils

sealed class ResultState<out T> {
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(val errorMessage: String) : ResultState<Nothing>()
    object Loading : ResultState<Nothing>()
}
