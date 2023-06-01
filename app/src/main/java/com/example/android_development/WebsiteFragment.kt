package com.example.android_development

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.BackStackEntry
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController
import com.example.android_development.databinding.FragmentAuthorizationBinding
import com.example.android_development.databinding.FragmentWebsiteBinding

class WebsiteFragment : Fragment() {
    lateinit var binding: FragmentWebsiteBinding
    private val dataAccount: Account by activityViewModels()
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding = FragmentWebsiteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            linkWebsite.setOnClickListener{
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(R.string.linkWebsite.toString())))
            }
            dataAccount.message.observe(activity as LifecycleOwner) {
                account.text = it
                back.setOnClickListener {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.container,AuthorizationFragment()).commit()
                }
            }
        }
    }
}