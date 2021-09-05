package com.example.kotlincleanarchitecture.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincleanarchitecture.data.model.ApiResult
import kotlinx.coroutines.*
import retrofit2.Response

open class BaseViewModel : ViewModel() {
    private val job = CoroutineScope(Job() + Dispatchers.Main)

    fun <T> handleGetRequest(_apiResult: MutableLiveData<ApiResult<T>>, request: suspend () -> Response<T>) {
        job.launch {
            _apiResult.postValue(ApiResult.Loading(Any()))
            try {
                request.invoke().let {
                    if (it.isSuccessful) {
                        it.body()?.let { data -> _apiResult.postValue(ApiResult.Success(data)) }
                    } else {
                        _apiResult.postValue(ApiResult.Error(Exception(it.errorBody()?.toString())))
                    }
                }
            } catch (e: Exception) {
                _apiResult.postValue(ApiResult.Error(Exception(e.message)))
            }
        }
    }


    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }

}