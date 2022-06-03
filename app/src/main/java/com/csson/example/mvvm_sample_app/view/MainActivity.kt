package com.csson.example.mvvm_sample_app.view

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.csson.example.mvvm_sample_app.R
import com.csson.example.mvvm_sample_app.base.BaseAppCompatActivity
import com.csson.example.mvvm_sample_app.databinding.ActivityMainBinding
import com.csson.example.mvvm_sample_app.viewmodel.MainViewModel

class MainActivity : BaseAppCompatActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, object: ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel() as T
            }
        }).get(MainViewModel::class.java)
    }

    override val layoutResId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.count.observe(this
        ) {
            binding.txtCount.text = it.toString()
        }

        binding.text.text = "이거로 바뀌는거니"

        binding.btnPlus.setOnClickListener {
            viewModel.plusCount(1)
        }

        binding.btnMinus.setOnClickListener {
            viewModel.minusCount(1)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(TAG, "onConfigurationChanged: ")
    }
}