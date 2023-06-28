package com.example.codingchallengespacex.mainScreen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codingchallengespacex.R
import com.example.codingchallengespacex.databinding.FragmentMainScreenBinding
import com.example.codingchallengespacex.mainScreen.ui.adapter.IOnclickItemRecyclerView
import com.example.codingchallengespacex.mainScreen.ui.adapter.ListLaunchesAdapter

class MainScreenFragment : Fragment(), IOnclickItemRecyclerView {

    private lateinit var mBinding: FragmentMainScreenBinding
    private val listLaunchesViewModel: ListLaunchesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listLaunchesViewModel.getListLaunches()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listLaunchesViewModel.listLaunch.observe(viewLifecycleOwner, Observer {
            it?.let { launches ->
                mBinding.recyclerView.adapter = ListLaunchesAdapter(launches, this)
                mBinding.recyclerView.layoutManager = LinearLayoutManager(context)
            }

        })
        /*mBinding.btnNavigation.setOnClickListener {
            findNavController().navigate(R.id.action_mainScreenFragment_to_detailFragment2)
        }*/
    }

    override fun onClick(launchId: String) {
        Toast.makeText(context, "Launch id Value $launchId", Toast.LENGTH_LONG).show()
        val direction = MainScreenFragmentDirections.actionMainScreenFragmentToDetailFragment2(launchId)
        findNavController().navigate(direction)
    }
}