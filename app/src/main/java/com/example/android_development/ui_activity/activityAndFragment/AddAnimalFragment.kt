package com.example.android_development.ui_activity.activityAndFragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import com.example.android_development.R
import com.example.android_development.databinding.FragmentAddAnimalBinding
import dev.lynko.cources2023.MyAnimalsApp
import dev.lynko.cources2023.RecyclerViewAdapter
import dev.lynko.cources2023.model.ValidateState
import dev.lynko.cources2023.repository.AnimalsRepository
import dev.lynko.cources2023.ui.activity.viewModel.AnimalsViewModel
import dev.lynko.cources2023.ui.activity.viewModel.AnimalsViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

class AddAnimalFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var viewModel: AnimalsViewModel
    private lateinit var binding: FragmentAddAnimalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddAnimalBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.actionBarSpinner.onItemSelectedListener
        val scope = CoroutineScope(SupervisorJob())
        viewModel = ViewModelProvider(
            this,
            AnimalsViewModelFactory(AnimalsRepository(MyAnimalsApp.INSTANCE.database.animalsDao()))
        ).get(AnimalsViewModel::class.java)
        viewModel.state.observe(viewLifecycleOwner) { status ->
            with(binding) {
                when (status) {
                    ValidateState.SUCCESS -> {
                        val name = nameEditText.run {
                            val textVar = text.toString()
                            text?.clear()
                            textVar}
                        val age = ageEditText.run {
                            val textVar = text.toString()
                            text?.clear()
                            textVar}
                        val weight = weightEditText.run {
                            val textVar = text.toString()
                            text?.clear()
                            textVar}
                        val description = descriptionEditText.run {
                            val textVar = text.toString()
                            text?.clear()
                            textVar}
                    }

                    ValidateState.FAIL -> {}
                    ValidateState.DEFAULT -> {}
                }
            }
        }
        with(binding) {
            add.setOnClickListener {
                viewModel.insertAnimal(
                    nameEditText.text.toString(),
                    ageEditText.text.toString(),
                    weightEditText.text.toString(),
                    actionBarSpinner.selectedItem.toString(),
                    when (radio.checkedRadioButtonId){
                        R.id.radio1-> R.drawable._cat1
                        R.id.radio2-> R.drawable._cat2
                        R.id.radio3-> R.drawable._cat3
                        else -> R.drawable._cat4
                    },
                    descriptionEditText.text.toString(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SS")
                        .withZone(ZoneOffset.UTC)
                        .format(Instant.now()),
                    //Теперь понял почему string. Но правильней будет записывать в бд просто long, а уже в adapter его
                    // отображать как тебе захочется
                )
            }
            removeAllAnimals.setOnClickListener {
                scope.launch(Dispatchers.Main) {
                    viewModel.deleteAllAnimal()
                }
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {}
    override fun onNothingSelected(parent: AdapterView<*>?) {}
}