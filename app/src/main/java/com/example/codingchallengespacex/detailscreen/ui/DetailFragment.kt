package com.example.codingchallengespacex.detailscreen.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codingchallengespacex.R
import com.example.codingchallengespacex.core.domain.IImageUtils
import com.example.codingchallengespacex.core.domain.utils.ResultState
import com.example.codingchallengespacex.databinding.FragmentDetailBinding
import com.example.codingchallengespacex.detailscreen.domain.models.DetailLaunch
import com.example.codingchallengespacex.detailscreen.ui.adapter.ListLaunchImagesAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment: Fragment() {

    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailViewModel by viewModel()

    private lateinit var mBinding: FragmentDetailBinding
    private lateinit var launchId: String

    private val imageLoader: IImageUtils by inject()

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
        mBinding = FragmentDetailBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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

    private fun showAlertError() {
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle("Something went wrong")
            .setPositiveButton("Ok", null)
            .show()
    }

    private fun setupView(detailData: DetailLaunch) {
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

    private fun setupViewLaunchButton(article: String) {
        mBinding.btnViewLaunch.setOnClickListener {
            val websiteIntent = Intent().apply {
                action = Intent.ACTION_VIEW
                data = Uri.parse(article)
            }
            if (websiteIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(websiteIntent)
            } else {
                Toast.makeText(context, R.string.intent_error, Toast.LENGTH_LONG).show()
            }
        }
    }


    private fun setupRecyclerView(images: List<String>) {
        mBinding.recyclerViewImages.apply {
            adapter = ListLaunchImagesAdapter(images, imageLoader)
            layoutManager = LinearLayoutManager(context)
        }
    }

}