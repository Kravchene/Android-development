package com.example.android_development.ui_activity.activityAndFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_development.databinding.FragmentAnimalsBinding
import dev.lynko.cources2023.MyAnimalsApp

import dev.lynko.cources2023.RecyclerViewAdapter
import dev.lynko.cources2023.repository.AnimalsRepository
import dev.lynko.cources2023.ui.activity.viewModel.AnimalsViewModel
import dev.lynko.cources2023.ui.activity.viewModel.AnimalsViewModelFactory


class AnimalsFragment : Fragment() {
    private lateinit var binding: FragmentAnimalsBinding
    private lateinit var viewModel: AnimalsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnimalsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RecyclerViewAdapter()
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = adapter
            recyclerView.setItemViewCacheSize(3)
            //А почему решил именно 3 ?
        }
        viewModel = ViewModelProvider(
            this,
            AnimalsViewModelFactory(AnimalsRepository(MyAnimalsApp.INSTANCE.database.animalsDao()))
        ).get(AnimalsViewModel::class.java)
        viewModel.animals.observe(viewLifecycleOwner) { animals ->
            adapter.setData(animals)
        }
        /*
        Можно пользоваться вариантом чуть короче
        viewModel.animals.observe { animals ->
            adapter.setData(animals)
        }
         */
    }



}