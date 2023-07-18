package com.example.codingchallengespacex.core.compose.states

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.codingchallengespacex.R


@Composable
fun LoadingState() {
    DetailDialogLoading()
}

@Composable
fun DetailDialogLoading() {
    Dialog(onDismissRequest = {}) {
        DetailCardContent()
    }
}

@Composable
fun DetailCardContent() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.rocket_launch_loading))
    val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.size(250.dp)
    )
}
