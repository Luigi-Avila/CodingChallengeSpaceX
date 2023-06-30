package com.example.codingchallengespacex.detailscreen.data.models

data class FairingsDTO(
    val recovered: Boolean,
    val recovery_attempt: Boolean,
    val reused: Boolean,
    val ships: List<Any>
)