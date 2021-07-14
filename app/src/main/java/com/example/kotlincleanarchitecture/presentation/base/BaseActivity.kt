package com.example.kotlincleanarchitecture.presentation.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {

    lateinit var mBinding: B

    abstract fun layoutId(): Int

    abstract fun onViewCreated()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<B>(this, layoutId())
        onViewCreated()
    }

    protected fun showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    protected fun showSnackBar(message:String){
        Snackbar.make(mBinding.root,message,Snackbar.LENGTH_LONG).show()
    }
}