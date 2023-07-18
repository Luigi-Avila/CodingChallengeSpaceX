package com.example.codingchallengespacex.detailscreen.ui.compose.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.codingchallengespacex.R
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch

@Composable
fun DetailsScreenSuccessState(
    launchData: DetailLaunch,
    goToBrowser: (String) -> Unit,
    getTitle: (String) -> Unit,
    goToGallery: (String) -> Unit
) {
    getTitle(launchData.name)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(
                dimensionResource(id = R.dimen.common_padding_default)
            )
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
        , verticalArrangement = Arrangement.Center
    ) {
        Text(text = launchData.name, style = MaterialTheme.typography.h5)
        Text(
            text = launchData.date,
            Modifier.padding(bottom = dimensionResource(id = R.dimen.common_padding_default))
        )
        AsyncImage(
            model = launchData.mainImage,
            contentDescription = stringResource(id = R.string.photo_mission_description),
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(bottom = dimensionResource(id = R.dimen.common_padding_default)),
            contentScale = ContentScale.Fit,
            placeholder = painterResource(id = R.drawable.spacex_logo),
            alignment = Alignment.Center
        )
        Button(
            onClick = { goToGallery(launchData.id) },
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.common_padding_min))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_photo_library),
                contentDescription = ""
            )
            Text(
                text = "View gallery",
                Modifier.padding(start = dimensionResource(id = R.dimen.common_padding_min))
            )
        }
        CardDescription(
            Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.common_padding_default)),
            goToBrowser,
            launchData
        )
    }

}

@Composable
fun CardDescription(modifier: Modifier, goToBrowser: (String) -> Unit, launchData: DetailLaunch) {
    Card(modifier = modifier) {
        Column(Modifier.padding(dimensionResource(id = R.dimen.common_padding_default))) {
            Row(
                Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Description",
                    modifier = Modifier.weight(2f),
                    style = MaterialTheme.typography.subtitle1
                )
                IconButton(onClick = { goToBrowser(launchData.article) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_rocket_launch),
                        contentDescription = ""
                    )
                }
            }
            launchData.description?.let { Text(text = it, style = MaterialTheme.typography.body1) }
        }
    }
}
