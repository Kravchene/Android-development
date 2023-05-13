package com.example.android_development

import android.content.Intent
import android.net.Uri
import android.os.BatteryManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.android_development.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binging: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binging.root)
        with(binging) {
            getBatteryCapacityButton.setOnClickListener {
                val cast = getSystemService(BATTERY_SERVICE) as? BatteryManager
                binging.textView.text =
                    cast?.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
                        .toString()
            }
            openLinkButton.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://support.google.com/pixelphone/answer/7015477?hl=en://www.mylink.com")
                    )
                )
            }
        }
    }
}
