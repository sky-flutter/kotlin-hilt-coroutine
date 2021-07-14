package com.example.kotlincleanarchitecture.presentation.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {
    lateinit var mBinding: B

    abstract fun layoutId(): Int

    abstract fun onViewCreated()

    abstract fun viewModelObservers()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModelObservers()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate<B>(inflater, layoutId(), container, false)
        onViewCreated()
        return mBinding.root
    }

}