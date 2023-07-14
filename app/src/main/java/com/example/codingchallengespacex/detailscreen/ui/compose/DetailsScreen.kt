package com.example.codingchallengespacex.detailscreen.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.codingchallengespacex.R
import com.example.codingchallengespacex.core.compose.states.ErrorState
import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch
import com.example.codingchallengespacex.detailscreen.ui.DetailViewModel
import com.example.codingchallengespacex.detailscreen.ui.compose.states.DetailsScreenLoadingState
import com.example.codingchallengespacex.detailscreen.ui.compose.states.DetailsScreenSuccessState


@Composable
fun DetailsScreen(
    detailViewModel: DetailViewModel,
    goToBrowser: (String) -> Unit,
    launchId: String,
    goBack: () -> Unit
) {

    val detailState: ResultState<DetailLaunch> by detailViewModel.launch.observeAsState(
        initial = ResultState.Loading
    )
    var title by rememberSaveable { mutableStateOf("Back") }



    Scaffold(topBar = {
        TopAppBar(title = { Text(text = title) }, navigationIcon = {
            IconButton(onClick = { goBack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.button_back)
                )
            }
        })
    }) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            when (detailState) {
                is ResultState.Error -> {
                    ErrorState {
                        detailViewModel.getOneLaunch(launchId)
                    }
                }

                ResultState.Loading -> {
                    DetailsScreenLoadingState()
                }

                is ResultState.Success -> {
                    DetailsScreenSuccessState(
                        (detailState as ResultState.Success<DetailLaunch>).data,
                        goToBrowser
                    ) {
                        title = it
                    }
                }
            }
        }

    }

}


