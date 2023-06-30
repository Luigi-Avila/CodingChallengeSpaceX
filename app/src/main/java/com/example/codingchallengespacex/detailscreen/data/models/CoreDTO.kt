package com.example.codingchallengespacex.detailscreen.data.models

data class CoreDTO(
    val core: String,
    val flight: Int,
    val gridfins: Boolean,
    val landing_attempt: Boolean,
    val landing_success: Any,
    val landing_type: Any,
    val landpad: Any,
    val legs: Boolean,
    val reused: Boolean
)