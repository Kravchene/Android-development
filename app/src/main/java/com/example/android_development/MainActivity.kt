package com.example.android_development

import android.content.Intent
import android.net.Uri
import android.os.BatteryManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.android_development.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binging: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.button.setOnClickListener {
            binging.textView.text= (getSystemService(BATTERY_SERVICE) as BatteryManager).getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY).toString()
        }
        binging.button2.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://support.google.com/pixelphone/answer/7015477?hl=en://www.mylink.com")
                )
            )
        }

    }
}
