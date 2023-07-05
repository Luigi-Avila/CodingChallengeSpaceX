package com.example.codingchallengespacex.core.data

import android.view.View
import android.widget.ImageView
import com.example.codingchallengespacex.R
import com.example.codingchallengespacex.core.domain.IImageUtils
import com.squareup.picasso.Picasso

class PicassoImageUtilsImp : IImageUtils {
    override fun loadImage(imageUrl: String, container: View) {
        Picasso.get().load(imageUrl)
            .placeholder(R.drawable.spacex_logo)
            .into(container as ImageView)
    }
}