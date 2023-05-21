package com.example.android_development

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ValueIntRandom: ViewModel() {
    val  message:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}