package com.example.kotlincleanarchitecture.presentation.activity.main

import androidx.activity.viewModels
import com.example.kotlincleanarchitecture.R
import com.example.kotlincleanarchitecture.databinding.ActivityMainBinding
import com.example.kotlincleanarchitecture.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mMainViewModel by viewModels<MainViewModel>()

    override fun layoutId() = R.layout.activity_main

    override fun onViewCreated() {
        // Bind view
    }

}