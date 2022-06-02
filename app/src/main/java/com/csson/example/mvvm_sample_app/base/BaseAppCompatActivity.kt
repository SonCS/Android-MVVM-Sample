package com.csson.example.mvvm_sample_app.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseAppCompatActivity<T: ViewDataBinding>: AppCompatActivity() {
//    protected val binding by lazy { T. }
    protected val TAG: String = this.javaClass.simpleName

    abstract val layoutResId: Int
    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setViewDataBinding()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewDataBinding()
    }

    private fun setViewDataBinding() {
        binding = DataBindingUtil.setContentView(this, layoutResId)
        binding.lifecycleOwner = this
    }
}