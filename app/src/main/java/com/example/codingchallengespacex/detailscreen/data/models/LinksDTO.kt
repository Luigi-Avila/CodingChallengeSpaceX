package com.example.codingchallengespacex.detailscreen.data.models

data class LinksDTO(
    val article: String,
    val flickr: FlickrDTO,
    val patch: PatchDTO,
    val presskit: Any,
    val reddit: RedditDTO,
    val webcast: String,
    val wikipedia: String,
    val youtube_id: String
)