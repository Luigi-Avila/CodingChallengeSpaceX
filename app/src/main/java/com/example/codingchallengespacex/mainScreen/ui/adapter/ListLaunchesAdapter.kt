package com.example.codingchallengespacex.mainScreen.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codingchallengespacex.R
import com.example.codingchallengespacex.core.utils.dateTimeFormat
import com.example.codingchallengespacex.databinding.LaunchItemBinding
import com.example.codingchallengespacex.mainScreen.data.models.ListLaunches
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.Locale

class ListLaunchesAdapter(
    private val launchesList: ListLaunches,
    private val listener: IOnclickItemRecyclerView
) :
    RecyclerView.Adapter<ListLaunchesAdapter.LaunchesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.launch_item, parent, false)
        return LaunchesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LaunchesViewHolder, position: Int) {
        val data = launchesList[position]
        with(holder) {
            setListener(data.id)
            binding.tvNameLaunch.text = data.name
            Picasso.get()
                .load(data.links.patch.small)
                .into(binding.imgCardPhoto)
            binding.tvDateTime.text = data.date_utc.dateTimeFormat()
        }
    }

    override fun getItemCount(): Int = launchesList.size

    inner class LaunchesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = LaunchItemBinding.bind(itemView)

        fun setListener(launchId: String) {
            binding.root.setOnClickListener {
                listener.onClick(launchId)
            }
        }

    }

}