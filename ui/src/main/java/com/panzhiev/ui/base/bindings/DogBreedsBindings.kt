package com.panzhiev.ui.base.bindings

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.panzhiev.domain.model.DogBreed
import com.panzhiev.ui.allbreeds.ui.DogBreedsAdapter

object DogBreedsBindings {

    @BindingAdapter("breeds")
    @JvmStatic
    fun RecyclerView.setBreeds(breeds: List<DogBreed>?) {
        (adapter as DogBreedsAdapter).submitList(breeds)
    }
}