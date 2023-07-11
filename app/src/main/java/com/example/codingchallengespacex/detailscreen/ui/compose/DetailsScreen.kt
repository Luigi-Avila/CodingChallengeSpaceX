package com.example.codingchallengespacex.detailscreen.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch
import com.example.codingchallengespacex.detailscreen.ui.DetailViewModel
import com.example.codingchallengespacex.detailscreen.ui.compose.states.DetailsScreenLoadingState
import com.example.codingchallengespacex.detailscreen.ui.compose.states.DetailsScreenSuccessState


@Composable
fun DetailsScreen(detailViewModel: DetailViewModel, goToBrowser: (String) -> Unit) {

    val detailState: ResultState<DetailLaunch> by detailViewModel.launch.observeAsState(
        initial = ResultState.Loading
    )

    when(detailState){
        is ResultState.Error -> {  }
        ResultState.Loading -> {
            DetailsScreenLoadingState()
        }
        is ResultState.Success -> {
            DetailsScreenSuccessState((detailState as ResultState.Success<DetailLaunch>).data, goToBrowser)
        }
    }

}


