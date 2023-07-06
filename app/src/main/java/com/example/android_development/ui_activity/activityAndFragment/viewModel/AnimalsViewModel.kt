package dev.lynko.cources2023.ui.activity.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dev.lynko.cources2023.model.Animal
import dev.lynko.cources2023.model.ValidateState
import dev.lynko.cources2023.repository.AnimalsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.format.DateTimeFormatter

class AnimalsViewModel(private val repository: AnimalsRepository): ViewModel() {

    private val _state: MutableLiveData<ValidateState> = MutableLiveData(ValidateState.DEFAULT)
    val state: LiveData<ValidateState> = _state

    //Похвально, что сразу LiveData
    val animals: LiveData<List<Animal>> = repository.getAllAnimasLiveData()

    fun insertAnimal(
        name: String,
        age: String,
        weight: String,
        type: String,
        avatar: Int,
        description: String,
        data: String
    ) {
        val animal = isDataValid(name, age, weight, type,description, avatar,data) ?: return
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertAnimal(animal)
        }
    }

    private fun isDataValid(name: String, age: String, weight: String, type: String,description:String,avatar: Int,data: String): Animal? {
        return try {
            val ageInt = age.toInt()
            val weightDouble = weight.toDouble()
            Animal(
                name = name,
                age = ageInt,
                weight = weightDouble,
                type = type,
                description = description,
                avatar = avatar,
                createdAt = data
            ).also {
                _state.value = ValidateState.SUCCESS
            }
        } catch (e: Exception) {
            _state.value = ValidateState.FAIL
            null
        }
    }
     suspend fun deleteAllAnimal(){
        repository.deleteAll()
    }
}

class AnimalsViewModelFactory(private val repository: AnimalsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnimalsViewModel::class.java)) {
            return AnimalsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown viewModel!")
    }
}