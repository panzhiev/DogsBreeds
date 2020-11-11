package com.panzhiev.ui.allbreeds.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.panzhiev.domain.model.DogBreed
import com.panzhiev.ui.R
import com.panzhiev.ui.base.extensions.setOnClickListenerWithDebounce
import com.panzhiev.ui.databinding.ItemDogBreedBinding

class DogBreedsAdapter(private val onItemClick: (DogBreed) -> Unit) :
    ListAdapter<DogBreed, DogBreedsAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogBreedsAdapter.ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_dog_breed,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DogBreedsAdapter.ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(private val binding: ItemDogBreedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: DogBreed) {
            binding.apply {
                root.setOnClickListenerWithDebounce { onItemClick(item) }
                breedNameTv.text = item.breedName
            }
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<DogBreed>() {
        override fun areItemsTheSame(oldItem: DogBreed, newItem: DogBreed) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: DogBreed, newItem: DogBreed): Boolean =
            oldItem == newItem
    }
}