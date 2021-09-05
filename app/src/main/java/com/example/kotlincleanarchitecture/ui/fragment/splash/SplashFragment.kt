package com.example.kotlincleanarchitecture.ui.fragment.splash

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlincleanarchitecture.R
import com.example.kotlincleanarchitecture.base.BaseFragment
import com.example.kotlincleanarchitecture.data.model.ApiResult
import com.example.kotlincleanarchitecture.databinding.FragmentSplashBinding
import com.example.kotlincleanarchitecture.ui.fragment.splash.adapter.UsersDataAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {

    private val mUsersDataAdapter: UsersDataAdapter by lazy { UsersDataAdapter() }

    private val mSplashViewModel by viewModels<SplashViewModel>()

    override fun layoutId() = R.layout.fragment_splash

    override fun onViewCreated() {
        // Bind view
        mBinding.rvUsers.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mUsersDataAdapter
        }
        mSplashViewModel.fetchUsers(1)
    }

    override fun viewModelObservers() {
        // Observer progress, error and data
        observeApiResponse()
    }

    private fun observeApiResponse() {
        mSplashViewModel.userData.observe(this, {
            mBinding.pbProgress.isVisible = it is ApiResult.Loading
            mBinding.tvError.isVisible = it is ApiResult.Error
            mBinding.rvUsers.isVisible = it is ApiResult.Success
            when (it) {
                is ApiResult.Success -> {
                    mUsersDataAdapter.updateData(it.data.data)
                }
                is ApiResult.Error -> {
                    mBinding.tvError.text = it.exception.message
                }
                else -> {
                    // Do nothing
                }
            }
        })
    }
}