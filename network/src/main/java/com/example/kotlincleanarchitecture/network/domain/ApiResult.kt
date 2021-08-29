package com.example.kotlincleanarchitecture.network.domain

sealed class ApiResult<out R> {
    data class Loading<out T>(val data: T) : ApiResult<T>()
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val exception: Exception) : ApiResult<Nothing>()
}
