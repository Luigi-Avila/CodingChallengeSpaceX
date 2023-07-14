package com.example.codingchallengespacex.mainscreen.ui.compose.states

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Chip
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
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
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainscreen.ui.ListLaunchesViewModel

@Composable
fun MainScreenSuccessState(
    launches: List<LaunchItem>,
    goToDetails: (String) -> Unit,
    launchesViewModel: ListLaunchesViewModel
) {

    LazyColumn() {
        item { Title(launchesViewModel, launches) }
        items(launches) { launch ->
            LaunchItemView(launch, goToDetails)
        }
    }

}

@Composable
fun LaunchItemView(launch: LaunchItem, goToDetails: (String) -> Unit) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(top = dimensionResource(id = R.dimen.common_padding_min))
            .clickable {
                goToDetails(launch.id)
            },
        elevation = 8.dp,
        shape = MaterialTheme.shapes.small,
    ) {
        ContentCardLaunch(launch)
    }
}

@Composable
fun ContentCardLaunch(launch: LaunchItem) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.common_padding_min))
    ) {
        AsyncImage(
            model = launch.image,
            contentDescription = stringResource(id = R.string.photo_mission_description),
            modifier = Modifier
                .width(100.dp)
                .fillMaxHeight(),
            contentScale = ContentScale.Fit,
            placeholder = painterResource(id = R.drawable.spacex_logo),
            error = painterResource(id = R.drawable.spacex_logo),
            alignment = Alignment.Center
        )
        Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
            Text(
                text = launch.name, modifier = Modifier.padding(
                    start = dimensionResource(
                        id = R.dimen.common_padding_min
                    )
                )
            )
            Text(
                text = launch.date_utc, modifier = Modifier.padding(
                    start = dimensionResource(
                        id = R.dimen.common_padding_min
                    )
                )
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(id = R.dimen.common_padding_min),
                        top = dimensionResource(
                            id = R.dimen.common_padding_min
                        )
                    )
            ) {
                if (launch.hasGallery) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_photo_library),
                        contentDescription = ""
                    )
                }
                if (launch.hasDescription) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_description),
                        contentDescription = ""
                    )
                }
            }

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Title(launchesViewModel: ListLaunchesViewModel, launches: List<LaunchItem>) {
    Column() {
        Text(
            text = stringResource(id = R.string.main_screen_title),
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .fillMaxWidth()
                .padding()
        )
        Row() {
            Chip(onClick = { launchesViewModel.filterByLaunchGallery(launches) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_photo_library),
                    contentDescription = ""
                )
                Text(text = "Gallery")
            }
            Chip(
                onClick = { launchesViewModel.filterByLaunchDescription(launches)  },
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.common_padding_min))
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_description),
                    contentDescription = ""
                )
                Text(text = "Description")
            }
            Chip(onClick = { launchesViewModel.getListLaunches() }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_rocket_launch),
                    contentDescription = ""
                )
                Text(text = "All")
            }
        }
    }


}