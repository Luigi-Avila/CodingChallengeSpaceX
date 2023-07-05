package com.example.codingchallengespacex.mainscreen.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codingchallengespacex.core.domain.IImageUtils
import com.example.codingchallengespacex.databinding.LaunchItemBinding
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem

class ListLaunchesAdapter(
    private val launchesList: List<LaunchItem>,
    private val listener: (String) -> Unit,
    private val imageLoader: IImageUtils
) :
    RecyclerView.Adapter<ListLaunchesAdapter.LaunchesViewHolder>() {

    private lateinit var mBinding: LaunchItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchesViewHolder {
        mBinding = LaunchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false )
        return LaunchesViewHolder(mBinding.root)

    }

    override fun onBindViewHolder(holder: LaunchesViewHolder, position: Int) {
        val data = launchesList[position]
        with(mBinding){
            root.setOnClickListener {
                listener.invoke(data.id)
            }
            tvNameLaunch.text = data.name
            data.image?.let{ imageLoader.loadImage(it, imgCardPhoto)}
            tvDateTime.text = data.date_utc
        }
    }

    override fun getItemCount(): Int = launchesList.size

    inner class LaunchesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}


}