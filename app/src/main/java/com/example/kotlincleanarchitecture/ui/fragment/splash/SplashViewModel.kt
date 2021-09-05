package com.example.kotlincleanarchitecture.ui.fragment.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlincleanarchitecture.data.datasource.remote.UsersRepository
import com.example.kotlincleanarchitecture.data.model.ApiResult
import com.example.kotlincleanarchitecture.base.BaseViewModel
import com.example.kotlincleanarchitecture.ui.fragment.splash.model.UsersData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val mUsersRepository: UsersRepository) : BaseViewModel() {
    private val _apiResult = MutableLiveData<ApiResult<UsersData>>()

    val userData: LiveData<ApiResult<UsersData>>
        get() = _apiResult


    fun fetchUsers(page: Int) {
        handleGetRequest(_apiResult) { mUsersRepository.fetchUsers(page) }
    }

}