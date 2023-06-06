package com.example.android_development

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.android_development.databinding.FragmentAuthorizationBinding

class AuthorizationFragment : Fragment() {
    lateinit var binding: FragmentAuthorizationBinding
    private val dataAccount: Account by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthorizationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            buttonLog.setOnClickListener {
                if (emailOrUs.text!!.isEmpty() || password.text!!.isEmpty()) {
                } else {
                    dataAccount.message.value = emailOrUs.text.toString()
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(R.id.container, WebsiteFragment()).commit()
                }
            }
        }
    }

}