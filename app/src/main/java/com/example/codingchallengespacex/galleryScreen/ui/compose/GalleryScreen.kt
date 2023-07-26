package com.example.codingchallengespacex.galleryScreen.ui.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.example.codingchallengespacex.core.compose.states.LoadingState
import com.example.codingchallengespacex.core.domain.utils.UIState
import com.example.codingchallengespacex.detailscreen.ui.DetailViewModel
import com.example.codingchallengespacex.galleryScreen.ui.compose.states.GalleryScreenSuccessState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GalleryScreen(
    detailViewModel: DetailViewModel,
    goBack: () -> Unit,
    nextPhoto: suspend (PagerState, Int) -> Unit
) {

    val galleryState: UIState<List<String>> by detailViewModel.images.observeAsState(initial = UIState.Loading)

    when (galleryState) {
        is UIState.Error -> {}
        UIState.Loading -> {
            LoadingState()
        }

        is UIState.Success -> {
            GalleryScreenSuccessState(images = (galleryState as UIState.Success<List<String>>).data, goBack, nextPhoto)
        }
    }

}