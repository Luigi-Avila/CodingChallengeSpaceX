package com.example.codingchallengespacex.galleryScreen.ui.compose.states

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.codingchallengespacex.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GalleryScreenSuccessState(
    images: List<String>,
    goBack: () -> Unit,
    nextPhoto: suspend (PagerState, Int) -> Unit
) {

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = stringResource(id = R.string.button_back)) },
            navigationIcon = {
                IconButton(onClick = { goBack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.button_back)
                    )
                }
            })
    }) { contentPadding ->
        ImagesPager(images, contentPadding, nextPhoto)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImagesPager(
    images: List<String>,
    contentPadding: PaddingValues,
    nextPhoto: suspend (PagerState, Int) -> Unit
) {

    val pagerState = rememberPagerState(initialPage = 0)

    val coroutineScope = rememberCoroutineScope()


    HorizontalPager(
        pageCount = images.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {

        AsyncImage(
            model = images[it],
            modifier = Modifier
                .fillMaxHeight()
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                },
            contentDescription = stringResource(id = R.string.photo_mission_description),
            placeholder = painterResource(id = R.drawable.spacex_logo),
            alignment = Alignment.Center
        )
    }
    ProgressIndicator(images.size, pagerState, contentPadding)


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProgressIndicator(size: Int, pagerState: PagerState, contentPadding: PaddingValues) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(contentPadding)
    ) {
        repeat(size) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color.White else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .background(color)
                    .height(2.dp)
                    .weight(1f)
            )
        }
    }
}
