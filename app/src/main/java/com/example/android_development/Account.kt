package com.example.android_development

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Account : ViewModel() {
    val  message: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}