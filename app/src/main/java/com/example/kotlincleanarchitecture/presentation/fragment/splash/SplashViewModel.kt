package com.example.kotlincleanarchitecture.presentation.fragment.splash

import com.example.kotlincleanarchitecture.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : BaseViewModel() {
//    fun fetchUsers(page: Int) {
//        job.launch {
//            val result = try {
//                mUsersRepository.fetchUsers(page)
//            } catch (e: Exception) {
//                ApiResult.Error(Exception("Error while fetching users"))
//            }
//            when (result) {
//                is ApiResult.Success<UserData> -> {
//                }
//                is ApiResult.Loading -> {
//
//                }
//                else -> {
//                }
//            }
//        }
//    }
}