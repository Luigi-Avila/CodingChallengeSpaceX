package com.example.codingchallengespacex.core.domain.utils

import com.example.codingchallengespacex.detailscreen.data.models.LaunchDTO
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch
import com.example.codingchallengespacex.mainscreen.data.models.LaunchesItemDTO
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem

fun LaunchesItemDTO.toDomain(): LaunchItem {
    return LaunchItem(
        details = this.details,
        name= this.name,
        date_utc = this.date_utc.dateTimeFormat(),
        id = this.id,
        image = this.links.patch.small
    )
}

fun LaunchDTO.toDomainDetail(): DetailLaunch {
    return DetailLaunch(
        name= this.name,
        date = this.date_utc.dateTimeFormat(),
        description = this.details,
        images = this.links.flickr.original,
        mainImage = this.links.patch.small
    )
}