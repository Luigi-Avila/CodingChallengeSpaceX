package com.example.codingchallengespacex.detailscreen.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.codingchallengespacex.R
import com.example.codingchallengespacex.databinding.FragmentDetailBinding
import com.example.codingchallengespacex.detailscreen.ui.compose.DetailsScreen
import com.google.accompanist.themeadapter.material.MdcTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailViewModel by viewModels()

    private lateinit var mBinding: FragmentDetailBinding
    private lateinit var launchId: String

    /*
        private val imageLoader: IImageUtils by inject()
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        launchId = args.launchId
        detailViewModel.getOneLaunch(launchId)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentDetailBinding.inflate(inflater, container, false).apply {
            detailsComposeView.apply {
                setViewCompositionStrategy(
                    ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
                )
                setContent {
                    MdcTheme {
                        DetailsScreen(
                            detailViewModel = detailViewModel,
                            this@DetailFragment::goToInternet,
                            launchId,
                            this@DetailFragment::goToList,
                            this@DetailFragment::goToGallery
                        )
                    }
                }
            }
        }
        return mBinding.root
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailViewModel.launch.observe(viewLifecycleOwner) {
            when (it) {
                is ResultState.Error -> {
                    showAlertError()
                }

                ResultState.Loading -> {}
                is ResultState.Success -> {
                    setupView(it.data)
                }
            }
        }
    }
    
     */

    /*
        private fun showAlertError() {
            MaterialAlertDialogBuilder(requireActivity())
                .setTitle("Something went wrong")
                .setPositiveButton("Ok", null)
                .show()
        }
    */

    /* private fun setupView(detailData: DetailLaunch) {
         with(mBinding){
             tvDetailName.text = detailData.name
             tvDetailDate.text = detailData.date
             tvDetailTextDescription.text = detailData.description
             detailData.mainImage?.let { imageLoader.loadImage(it, imgMissionPhoto) }
         }
         setupViewLaunchButton(detailData.article)
         if (!detailData.images.isNullOrEmpty()){
             setupRecyclerView(detailData.images)
         }
     }

     private fun setupRecyclerView(images: List<String>) {
         mBinding.recyclerViewImages.apply {
             adapter = ListLaunchImagesAdapter(images, imageLoader)
             layoutManager = LinearLayoutManager(context)
         }
     }*/

    private fun goToInternet(articleURL: String) {
        val websiteIntent = Intent().apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse(articleURL)
        }
        if (websiteIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(websiteIntent)
        } else {
            Toast.makeText(context, R.string.intent_error, Toast.LENGTH_LONG).show()
        }

    }

    private fun goToList() {
        findNavController().popBackStack()
    }

    private fun goToGallery(launchId: String) {
        val direction = DetailFragmentDirections.actionDetailFragment2ToGalleryFragment2(launchId)
        findNavController().navigate(direction)
    }

}