package com.example.android_development

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    private val dataAccount:Account by viewModels()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataAccount.message.observe(this,{})

        }
    }
