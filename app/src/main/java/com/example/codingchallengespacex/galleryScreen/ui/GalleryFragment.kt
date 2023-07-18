package com.example.codingchallengespacex.galleryScreen.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.codingchallengespacex.databinding.FragmentGalleryBinding
import com.example.codingchallengespacex.detailscreen.ui.DetailViewModel
import com.example.codingchallengespacex.galleryScreen.ui.compose.GalleryScreen
import com.google.accompanist.themeadapter.material.MdcTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GalleryFragment : Fragment() {

    private val args: GalleryFragmentArgs by navArgs()

    private val sharedViewModel: DetailViewModel by viewModels()

    private lateinit var mBinding: FragmentGalleryBinding
    private lateinit var galleryId: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        galleryId = args.galleryId
        Toast.makeText(
            this@GalleryFragment.context,
            "Valor de las images $galleryId",
            Toast.LENGTH_LONG
        ).show()
        sharedViewModel.getGallery(galleryId)
    }

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentGalleryBinding.inflate(inflater, container, false).apply {
            galleryComposeView.apply {
                setViewCompositionStrategy(
                    ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
                )
                setContent {
                    MdcTheme {
                        GalleryScreen(
                            sharedViewModel,
                            this@GalleryFragment::goBack,
                            nextPhoto = { pagerState, limit ->
                                nextPhoto(pagerState, limit)
                            })
                    }
                }
            }
        }
        return mBinding.root
    }

    private fun goBack() {
        findNavController().popBackStack()
    }

    @OptIn(ExperimentalFoundationApi::class)
    private suspend fun nextPhoto(pagerState: PagerState, limit: Int) {
        if (pagerState.currentPage < limit) {
            Log.i("Coroutine", "PAsss the coroutine")
            lifecycleScope.launch(Dispatchers.Main) {
                pagerState.animateScrollToPage(pagerState.currentPage + 1)
            }
        }

    }


}