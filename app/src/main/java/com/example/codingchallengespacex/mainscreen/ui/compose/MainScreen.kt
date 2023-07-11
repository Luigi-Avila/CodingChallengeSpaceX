package com.example.codingchallengespacex.mainscreen.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.codingchallengespacex.R
import com.example.codingchallengespacex.core.compose.states.ErrorState
import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainscreen.ui.ListLaunchesViewModel
import com.example.codingchallengespacex.mainscreen.ui.compose.states.MainScreenLoadingState
import com.example.codingchallengespacex.mainscreen.ui.compose.states.MainScreenSuccessState


@Composable
fun MainScreen(
    launchesViewModel: ListLaunchesViewModel,
    goToDetails: (String) -> Unit,
    showErrorToast: (String) -> Unit
) {

    val listState: ResultState<List<LaunchItem>> by launchesViewModel.listLaunch.observeAsState(
        initial = ResultState.Loading
    )

    Box(
        modifier = Modifier
            .padding(horizontal = dimensionResource(id = R.dimen.common_padding_min))
            .padding(
                top = dimensionResource(
                    id = R.dimen.common_padding_min
                )
            )
    ) {
        when (listState) {
            is ResultState.Error -> {
                ErrorState { launchesViewModel.getListLaunches() }
                showErrorToast((listState as ResultState.Error).errorMessage)
            }

            ResultState.Loading -> {
                MainScreenLoadingState()
            }

            is ResultState.Success -> {
                MainScreenSuccessState((listState as ResultState.Success<List<LaunchItem>>).data, goToDetails)
            }
        }
    }


}




