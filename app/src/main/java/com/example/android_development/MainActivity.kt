package com.example.android_development


import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
private val intData:ValueIntRandom by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Еще не проходили, но вопрос: что ты выполняешь при обзерве message ?) 
        intData.message.observe(this,{})


    }

}
