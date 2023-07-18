package com.example.codingchallengespacex.detailscreen.domain.models

data class DetailLaunch(
    val name: String = "",
    val date: String = "",
    val description: String? = "",
    val images: List<String>? = emptyList(),
    val mainImage: String? = "",
    val article: String = "",
    val id: String = ""
)
