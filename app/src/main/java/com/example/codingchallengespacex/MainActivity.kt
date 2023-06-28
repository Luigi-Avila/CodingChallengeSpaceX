package com.example.codingchallengespacex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codingchallengespacex.databinding.ActivityMainBinding
import com.example.codingchallengespacex.mainScreen.ui.ListLaunchesAdapter
import com.example.codingchallengespacex.mainScreen.ui.ListLaunchesViewModel
import com.example.codingchallengespacex.mainScreen.ui.OnClickListener

class MainActivity : AppCompatActivity(), OnClickListener {

    private val listLaunchesViewModel: ListLaunchesViewModel by viewModels()

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        listLaunchesViewModel.getListLaunches()

        listLaunchesViewModel.listLaunch.observe(this, Observer {

            mBinding.recyclerView.adapter = ListLaunchesAdapter(it!!, this)
            mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
            mBinding.recyclerView.setHasFixedSize(true)
        })
    }

    override fun onClick(launchId: String) {
        Toast.makeText(this, "this is the id of the launch $launchId", Toast.LENGTH_LONG).show()
    }
}