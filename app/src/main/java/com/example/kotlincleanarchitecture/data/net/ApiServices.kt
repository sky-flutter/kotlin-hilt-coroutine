package com.example.kotlincleanarchitecture.data.net

import com.example.kotlincleanarchitecture.ui.fragment.splash.model.UsersData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET(EndPoints.FETCH_USERS)
    suspend fun fetchUsers(@Query("page")page:Int): Response<UsersData>
}