package com.example.codingchallengespacex.detailscreen.data.models

data class LaunchDTO(
    val auto_update: Boolean,
    val capsules: List<Any>,
    val cores: List<CoreDTO>,
    val crew: List<Any>,
    val date_local: String,
    val date_precision: String,
    val date_unix: Int,
    val date_utc: String,
    val details: String,
    val failures: List<FailureDTO>,
    val fairings: FairingsDTO,
    val flight_number: Int,
    val id: String,
    val launch_library_id: Any,
    val launchpad: String,
    val links: LinksDTO,
    val name: String,
    val net: Boolean,
    val payloads: List<String>,
    val rocket: String,
    val ships: List<Any>,
    val static_fire_date_unix: Int,
    val static_fire_date_utc: String,
    val success: Boolean,
    val tbd: Boolean,
    val upcoming: Boolean,
    val window: Int
)