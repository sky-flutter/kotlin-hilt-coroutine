package com.example.kotlincleanarchitecture.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

open class BaseViewModel : ViewModel() {
    val job = CoroutineScope(Job() + Dispatchers.Main)

    override fun onCleared() {
        job.cancel()
        super.onCleared()
    }
}