package com.example.codingchallengespacex.mainscreen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.findNavController
import com.example.codingchallengespacex.R
import com.example.codingchallengespacex.core.domain.IImageUtils
import com.example.codingchallengespacex.databinding.FragmentMainScreenBinding
import com.example.codingchallengespacex.mainscreen.domain.models.LaunchItem
import com.example.codingchallengespacex.mainscreen.ui.compose.MainScreen
import com.google.accompanist.themeadapter.material.MdcTheme
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainScreenFragment : Fragment() {

    private lateinit var mBinding: FragmentMainScreenBinding
    private val listLaunchesViewModel: ListLaunchesViewModel by viewModel()

    private val imageLoader: IImageUtils by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //This is for the compose view
        mBinding = FragmentMainScreenBinding.inflate(inflater, container, false).apply {
            composeView.apply {
                /*
                Dispose the Composition when the view's LifecycleOwner is destroyed
                 it's best practice to always set this strategy when using ComposeView in fragments.
                */
                setViewCompositionStrategy(
                    ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
                )
                setContent {
                    MdcTheme {
                        MainScreen(listLaunchesViewModel)
                    }
                }
            }
        }
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*listLaunchesViewModel.listLaunch.observe(viewLifecycleOwner) {
            when(it){
                is ResultState.Error -> {
                    showDialog()
                }
                ResultState.Loading -> {
                    showLoadingDialog()
                }
                is ResultState.Success -> {
                    setupRecyclerView(it.data)
                }
            }

        }*/

    }

    private fun showLoadingDialog() {
        MaterialAlertDialogBuilder(requireActivity()).setView(R.layout.loading_screen)
            .show()
    }

    private fun setupRecyclerView(launches: List<LaunchItem>) {
        /*mBinding.recyclerView.adapter = ListLaunchesAdapter(launches, this::onClick, imageLoader)
        mBinding.recyclerView.layoutManager = LinearLayoutManager(context)*/
    }

    private fun showDialog() {
        MaterialAlertDialogBuilder(requireActivity())
            .setTitle(R.string.dialog_title_error)
            .setPositiveButton(R.string.dialog_positive_button_error) { _, _ ->
                requireActivity().finish()
            }

    }

    private fun onClick(launchId: String) {
        val direction =
            MainScreenFragmentDirections.actionMainScreenFragmentToDetailFragment2(launchId)
        findNavController().navigate(direction)
    }
}