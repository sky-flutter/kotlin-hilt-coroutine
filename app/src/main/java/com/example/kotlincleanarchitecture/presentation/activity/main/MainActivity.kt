package com.example.kotlincleanarchitecture.presentation.activity.main

import com.example.kotlincleanarchitecture.R
import com.example.kotlincleanarchitecture.databinding.ActivityMainBinding
import com.example.kotlincleanarchitecture.presentation.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun layoutId() = R.layout.activity_main

    override fun onViewCreated() {
        // Bind view
    }

}