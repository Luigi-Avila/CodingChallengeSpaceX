package com.example.codingchallengespacex.core.compose.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.codingchallengespacex.R

@Composable
fun ErrorState(refresh: () -> Unit) {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ErrorImage()
        ErrorTitle()
        ErrorButtonRefresh(refresh)
    }
}

@Composable
fun ErrorButtonRefresh(refresh: () -> Unit) {
    Button(
        onClick = { refresh() },
        Modifier.padding(top = dimensionResource(id = R.dimen.common_padding_default))
    ) {
        Text(text = stringResource(id = R.string.error_refresh))
    }
}

@Composable
fun ErrorTitle() {
    Text(
        text = "Something went wrong",
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(
            top = dimensionResource(
                id = R.dimen.common_padding_default
            )
        )
    )
}

@Composable
fun ErrorImage() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.astronaut_error))
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.size(250.dp),

        )
}
