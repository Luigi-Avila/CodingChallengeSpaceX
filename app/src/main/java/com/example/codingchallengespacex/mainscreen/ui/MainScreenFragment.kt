package com.example.codingchallengespacex.mainscreen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codingchallengespacex.core.utils.ResultState
import com.example.codingchallengespacex.databinding.FragmentMainScreenBinding
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainscreen.ui.adapter.IOnclickItemRecyclerView
import com.example.codingchallengespacex.mainscreen.ui.adapter.ListLaunchesAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment(), IOnclickItemRecyclerView {

    private lateinit var mBinding: FragmentMainScreenBinding
    private val listLaunchesViewModel: ListLaunchesViewModel by viewModel()

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

        listLaunchesViewModel.listLaunch.observe(viewLifecycleOwner) {
            /*it?.let { launches ->
                mBinding.progressbarMainScreen.visibility = View.GONE
                mBinding.recyclerView.adapter = ListLaunchesAdapter(launches, this)
                mBinding.recyclerView.layoutManager = LinearLayoutManager(context)
            }*/
            when(it){
                is ResultState.Error -> { showDialog() }
                ResultState.Loading -> { Toast.makeText(context, "Holaaa", Toast.LENGTH_SHORT).show() }
                is ResultState.Success -> { setupRecyclerView(it.data) }
            }

        }

    }

    private fun setupRecyclerView(launches: List<LaunchItem>) {
        mBinding.recyclerView.adapter = ListLaunchesAdapter(launches, this)
        mBinding.recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun showDialog() {
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle("Algo salio mal")
            .setPositiveButton("Salir", null)
            .show()
    }


    override fun onClick(launchId: String) {
        /*Toast.makeText(context, "Launch id Value $launchId", Toast.LENGTH_LONG).show()*/
        val direction = MainScreenFragmentDirections.actionMainScreenFragmentToDetailFragment2(launchId)
        findNavController().navigate(direction)
    }
}