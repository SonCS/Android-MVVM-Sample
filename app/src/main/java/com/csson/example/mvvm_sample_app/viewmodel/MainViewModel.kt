package com.csson.example.mvvm_sample_app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    private val _count = MutableLiveData(0)
    val count: LiveData<Int> get() =  _count

    fun plusCount(value: Int) {
        _count.value = (count.value ?: 0) + value
    }

    fun minusCount(value: Int) {
        _count.value = (count.value ?: 0) - value
    }
}