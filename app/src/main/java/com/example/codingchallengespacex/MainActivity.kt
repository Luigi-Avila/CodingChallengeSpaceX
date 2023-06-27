package com.example.codingchallengespacex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.codingchallengespacex.databinding.ActivityMainBinding
import com.example.codingchallengespacex.mainScreen.ui.ListLaunchesViewModel

class MainActivity : AppCompatActivity() {

    private val listLaunchesViewModel: ListLaunchesViewModel by viewModels()

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        listLaunchesViewModel.getListLaunches()
    }
}