package com.example.codingchallengespacex.detailscreen.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codingchallengespacex.R
import com.example.codingchallengespacex.databinding.LaunchImageItemBinding
import com.squareup.picasso.Picasso

class ListLaunchImagesAdapter(private val listImages: List<String>): RecyclerView.Adapter<ListLaunchImagesAdapter.ImagesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.launch_image_item, parent, false)
        return ImagesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        val data = listImages[position]
        with(holder){
            Picasso.get().load(data).into(binding.imgLaunchGallery)
        }
    }

    override fun getItemCount(): Int = listImages.size

    inner class ImagesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = LaunchImageItemBinding.bind(itemView)

    }
}