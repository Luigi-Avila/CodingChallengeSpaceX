package com.example.codingchallengespacex.core.utils

sealed class ResultGetLaunches<T> {
    data class Success<T>(val data: T): ResultGetLaunches<T>()
    data class Error<T>(val message: String): ResultGetLaunches<T>()
}
