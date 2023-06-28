package com.example.android_development.ui_activity.activityAndFragment.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_development.ui_activity.activityAndFragment.AddAnimalFragment
import com.example.android_development.ui_activity.activityAndFragment.AnimalsFragment

class FragmentPageAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0)
            AddAnimalFragment()
        else
            AnimalsFragment()
    }
}