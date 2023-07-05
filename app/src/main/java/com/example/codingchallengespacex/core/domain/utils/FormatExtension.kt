package com.example.codingchallengespacex.core.domain.utils

import java.text.SimpleDateFormat
import java.util.Locale

fun String.dateTimeFormat(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    val outputFormat = SimpleDateFormat("M/d/yyyy h:mm a", Locale.getDefault())
    val date = inputFormat.parse(this)
    return outputFormat.format(date)
}