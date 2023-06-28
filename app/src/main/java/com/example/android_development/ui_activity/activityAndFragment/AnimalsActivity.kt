package com.example.android_development.ui_activity.activityAndFragment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.android_development.R
import com.example.android_development.databinding.ActivityMainBinding
import com.example.android_development.ui_activity.activityAndFragment.Adapter.FragmentPageAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dev.lynko.cources2023.MyAnimalsApp.Companion.INSTANCE
import dev.lynko.cources2023.RecyclerViewAdapter


class AnimalsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var tabLayout: TabLayout

    private lateinit var viewPager2: ViewPager2

    private lateinit var adapter: FragmentPageAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabLayout = findViewById(R.id.tabMode)
        viewPager2 = findViewById(R.id.viewPager2)

        adapter = FragmentPageAdapter(this)
        viewPager2.adapter = adapter

        tabLayout.addTab(tabLayout.newTab().setText("   Add a pet  "))
        tabLayout.addTab(tabLayout.newTab().setText("    My pets   "))



        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager2.currentItem = tab.position
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })


    }
}