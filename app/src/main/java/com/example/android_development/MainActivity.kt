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
        //Эта строчка лишняя, так как на 22 мы устанавливаем из биндинга. 
        //setContentView тяжелая в плане производительности функция, поэтому
        //не стоит допускать ее вызова несколько раз на одном экране
        setContentView(R.layout.activity_main)
        binging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binging.root)
        //Рекомендация
        //Здесь можно было обернуть в scope функцию with()
        //Удобно, так как не приходится постоянно писать binding.name
        /*
        with(binding) {
            button.setOnClickListener {
                binging.textView.text = (getSystemService(BATTERY_SERVICE) as BatteryManager).getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY).toString()
            }
            button2.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://support.google.com/pixelphone/answer/7015477?hl=en://www.mylink.com")
                    )
                )
            }
        }
        */
        //Не забываем про корректные нейминги(get_battery_capacity_button и open_link_button, capacity_text) к примеру
        binging.button.setOnClickListener {
            // 1)(getSystemService(BATTERY_SERVICE) as BatteryManager) можно было запомнить в переменную один раз,
                //так как на каждое нажатие кнопки, мы будем брать системный сервис и кастить его
                //и если юзер начнет спамить нажатиями на кнопку, телефону будет немного неприятно)
            // 2) Лучше обезопашивать и приучать себя сразу испольвать as?, чтобы сразу обрабатывать ClassCastException,
                //на всякий случай))
            binging.textView.text= (getSystemService(BATTERY_SERVICE) as BatteryManager).getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY).toString()
        }
        binging.button2.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    //Статические ссылки, как и все строки желательно указывать в string.xml
                    Uri.parse("https://support.google.com/pixelphone/answer/7015477?hl=en://www.mylink.com")
                )
            )
        }

    }
}
