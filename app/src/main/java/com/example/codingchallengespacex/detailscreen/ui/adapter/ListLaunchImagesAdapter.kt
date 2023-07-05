package com.example.codingchallengespacex.detailscreen.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codingchallengespacex.core.domain.IImageUtils
import com.example.codingchallengespacex.databinding.LaunchImageItemBinding

class ListLaunchImagesAdapter(
    private val listImages: List<String>,
    private val imageLoader: IImageUtils
    ) : RecyclerView.Adapter<ListLaunchImagesAdapter.ImagesViewHolder>() {

    private lateinit var mBinding: LaunchImageItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        mBinding = LaunchImageItemBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return ImagesViewHolder(mBinding.root)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        val data = listImages[position]
        with(mBinding){
            imageLoader.loadImage(data,imgLaunchGallery)
        }
    }

    override fun getItemCount(): Int = listImages.size

    inner class ImagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}
}