package com.example.kotlincleanarchitecture.data.model

sealed class ApiResult<out R> {
    data class Loading<T>(val data: Any) : ApiResult<T>()
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val exception: Exception) : ApiResult<Nothing>()
}
