package com.example.codingchallengespacex.detailScreen.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codingchallengespacex.R
import com.example.codingchallengespacex.databinding.FragmentDetailBinding
import com.example.codingchallengespacex.detailScreen.ui.adapter.ListLaunchImagesAdapter
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()
    private val detailViewModel: DetailViewModel by viewModel()

    private lateinit var mBinding: FragmentDetailBinding
    private lateinit var launchId: String

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

        detailViewModel.launch.observe(viewLifecycleOwner, Observer {
            it?.let { launchData ->
                mBinding.tvDetailName.text = launchData.name
                mBinding.tvDetailTextDescription.text = launchData.description
                mBinding.tvDetailDate.text = launchData.date
                Picasso.get().load(launchData.mainImage).into(mBinding.imgMissionPhoto)

                mBinding.progressbarDetail.visibility = View.GONE
                mBinding.scrollViewInformation.visibility = View.VISIBLE

                launchData.images?.let { images ->
                    setupRecyclerView(images)
                }
                setupViewLaunchButton(launchData.article)
            }
        })
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
            adapter = ListLaunchImagesAdapter(images)
            layoutManager = LinearLayoutManager(context)
        }
    }

}