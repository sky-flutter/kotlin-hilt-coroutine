package com.example.kotlincleanarchitecture.presentation.fragment.splash

import androidx.fragment.app.viewModels
import com.example.kotlincleanarchitecture.R
import com.example.kotlincleanarchitecture.databinding.FragmentSplashBinding
import com.example.kotlincleanarchitecture.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    private val mSplashViewModel by viewModels<SplashViewModel>()

    override fun layoutId() = R.layout.fragment_splash

    override fun onViewCreated() {
        // Bind view
//        mSplashViewModel.fetchUsers(1)
    }

    override fun viewModelObservers() {
        // Observer progress, error and data
    }
}