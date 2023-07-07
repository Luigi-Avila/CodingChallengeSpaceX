package com.example.codingchallengespacex.mainscreen.ui.compose.states

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.codingchallengespacex.R

@Preview(showSystemUi = true)
@Composable
fun MainScreenLoadingState() {
    DialogLoading()
}


@Composable
fun DialogLoading() {
    Dialog(onDismissRequest = {}) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Card(Modifier.fillMaxWidth(), shape = RoundedCornerShape(18.dp)) {
                ContentDialog()
            }
        }
    }
}

@Composable
fun ContentDialog() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
    val progress by animateLottieCompositionAsState(composition)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(25.dp)
    ) {
        Text(text = stringResource(id = R.string.dialog_title_loading), textAlign = TextAlign.Center, style = MaterialTheme.typography.h6)
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier.size(250.dp)
        )
    }

}


