package com.example.codingchallengespacex.core.utils

sealed class ResultGetListLaunches<T> {
    data class Success<T>(val data: T): ResultGetListLaunches<T>()
    data class Error<T>(val message: String): ResultGetListLaunches<T>()
}
