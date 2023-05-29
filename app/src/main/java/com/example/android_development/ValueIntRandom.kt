package com.example.android_development

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ValueIntRandom: ViewModel() {
    //Не проходили, но иметь публичную mutableLiveData не есть хорошая практика
    val  message:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}
