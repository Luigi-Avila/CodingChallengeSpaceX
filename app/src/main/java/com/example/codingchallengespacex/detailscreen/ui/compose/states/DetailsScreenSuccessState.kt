package com.example.codingchallengespacex.detailscreen.ui.compose.states

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
    launch: DetailLaunch,
    goToBrowser: (String) -> Unit,
    getTitle: (String) -> Unit
) {

    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.common_padding_default))
    ) {
        item {
            Text(text = launch.date)
            getTitle(launch.name)
        }
        item {
            launch.mainImage?.let { url ->
                launch.description?.let { description ->
                    Body(
                        url,
                        description,
                        launch.article,
                        goToBrowser
                    )
                }
            }
        }
        if (!launch.images.isNullOrEmpty()) {
            item { Text(text = "Gallery", style = MaterialTheme.typography.h6) }
            items(launch.images) { image ->
                AsyncImage(
                    model = image,
                    modifier = Modifier.padding(top = dimensionResource(id = R.dimen.common_padding_default)),
                    contentDescription = stringResource(id = R.string.detail_screen_gallery),
                    placeholder = painterResource(id = R.drawable.spacex_logo),
                    error = painterResource(id = R.drawable.spacex_logo)
                    )

            }
        }
    }

}

@Composable
fun Body(
    imageUrl: String,
    articleUrl: String,
    description: String,
    goToBrowser: (String) -> Unit,
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = dimensionResource(id = R.dimen.common_padding_default)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = stringResource(id = R.string.photo_mission_description),
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Fit,
            placeholder = painterResource(id = R.drawable.spacex_logo),
            alignment = Alignment.Center
        )
        CardDetail(description, articleUrl, goToBrowser)
    }
}

@Composable
fun CardDetail(description: String, articleUrl: String, goToBrowser: (String) -> Unit) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(id = R.dimen.common_padding_default))
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.common_padding_default))
        ) {
            Row(
                Modifier
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.detai_screen_description),
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.weight(2f)
                )
                IconButton(onClick = { goToBrowser(articleUrl) }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_rocket_launch),
                        contentDescription = "launch"
                    )
                }
            }
            Text(text = description)
        }

    }
}
