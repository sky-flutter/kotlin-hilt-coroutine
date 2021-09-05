package com.example.kotlincleanarchitecture.data.datasource.remote

import com.example.kotlincleanarchitecture.data.net.ApiServices
import com.example.kotlincleanarchitecture.ui.fragment.splash.model.UsersData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class UsersRepository @Inject constructor(private val mApiService: ApiServices) {

    suspend fun fetchUsers(page: Int): Response<UsersData> {
        return withContext(Dispatchers.IO) {
            return@withContext mApiService.fetchUsers(page)
        }
    }

}