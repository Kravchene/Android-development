package dev.lynko.cources2023

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android_development.R
import com.example.android_development.databinding.ListAnimalBinding
import dev.lynko.cources2023.model.Animal
import dev.lynko.cources2023.ui.activity.viewModel.AnimalsViewModel



class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var animalList: MutableList<Animal> = mutableListOf()

    inner class MyViewHolder(private val itemBinding: ListAnimalBinding) : RecyclerView.ViewHolder(itemBinding.root),
        LifecycleOwner {
        fun bind(animal: Animal) {
                itemBinding.age.text = animal.age.toString()
                itemBinding.weight.text = animal.weight.toString()
                itemBinding.petName.text = animal.name
                itemBinding.description.text = animal.description
                itemBinding.typeOfPet.text = animal.type
                itemBinding.dateOfBirth.text = animal.createdAt
                itemBinding.image.setImageResource(animal.avatar)
        }
        override fun getLifecycle(): Lifecycle {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding = ListAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val animal = animalList[position]
        holder.bind(animal)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    fun setData(newList: List<Animal>) {
        val diffC = DiffCallback(animalList, newList)
        val result = DiffUtil.calculateDiff(diffC)
        animalList.clear()
        animalList.addAll(newList)
        result.dispatchUpdatesTo(this)
    }


class DiffCallback(private val oldList: List<Animal>, private val newList: List<Animal>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = oldList[newItemPosition]
        return oldItem == newItem

    }
}
}