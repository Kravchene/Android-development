package com.example.android_development

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.example.android_development.databinding.FragmentBlankBinding



class ResultFragment : Fragment(),NavigationApplication {
    lateinit var binding: FragmentBlankBinding
    private val intData:ValueIntRandom by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBlankBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            intData.message.observe(activity as LifecycleOwner) {
                textView.text = it.toString()
            }
            back.setOnClickListener{
                navigationApplication()
            }
        }

    }

    override fun navigationApplication() {
        findNavController().navigate(R.id.action_resultFragment_to_startFragment)
    }
}