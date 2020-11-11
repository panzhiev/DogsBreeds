package com.panzhiev.ui.allbreeds.ui

import androidx.lifecycle.ViewModelProvider
import com.panzhiev.ui.R
import com.panzhiev.ui.allbreeds.viewmodel.DogsBreedsViewModel
import com.panzhiev.ui.base.BaseFragment
import com.panzhiev.ui.base.ViewModelFactory
import com.panzhiev.ui.databinding.FragmentDogsBreedsBinding
import javax.inject.Inject

class DogsBreedsFragment : BaseFragment<FragmentDogsBreedsBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<DogsBreedsViewModel>

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(DogsBreedsViewModel::class.java)
    }

    override val layoutId = R.layout.fragment_dogs_breeds

    override fun setupBinding(binding: FragmentDogsBreedsBinding) {
        binding.vm = viewModel
    }

    override fun setupViews() {
        // todo
    }
}