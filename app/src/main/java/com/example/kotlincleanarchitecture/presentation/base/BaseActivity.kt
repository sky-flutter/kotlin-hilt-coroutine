package com.example.kotlincleanarchitecture.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding, V : ViewModel> : AppCompatActivity() {
    lateinit var mBinding: B

    @Inject
    lateinit var mViewModel: V

    abstract fun layoutId(): Int

    abstract fun onViewCreated()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<B>(this, layoutId())
        onViewCreated()
    }

}