package com.panzhiev.ui.breeddetails.ui

import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import com.panzhiev.domain.model.DogBreed
import com.panzhiev.ui.R
import com.panzhiev.ui.base.BaseFragment
import com.panzhiev.ui.base.ViewModelFactory
import com.panzhiev.ui.breeddetails.viewmodel.BreedDetailsNavigation
import com.panzhiev.ui.breeddetails.viewmodel.BreedDetailsViewModel
import com.panzhiev.ui.databinding.FragmentBreedDetailsBinding
import javax.inject.Inject

class BreedDetailsFragment : BaseFragment<FragmentBreedDetailsBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<BreedDetailsViewModel>

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(BreedDetailsViewModel::class.java)
    }

    override val layoutId = R.layout.fragment_breed_details

    override fun setupBinding(binding: FragmentBreedDetailsBinding) {
        binding.vm = viewModel
    }

    override fun setupViews() {
        viewModel.observeNavigation(this) { navigateTo(it) }
        binding.apply {
            breedDetailsToolbar.setNavigationOnClickListener {
                navigateTo(BreedDetailsNavigation.Back)
            }
            breedImagesRv.adapter = BreedImagesAdapter()
        }
    }

    private fun navigateTo(navigation: BreedDetailsNavigation) {
        when (navigation) {
            is BreedDetailsNavigation.Back -> navController.popBackStack()
            is BreedDetailsNavigation.Error -> showToast(getString(R.string.error_common))
        }
    }

    companion object {
        const val ARG_DOG_BREED = "ARG_DOG_BREED"
        fun getBundle(dogBreed: DogBreed) = bundleOf(ARG_DOG_BREED to dogBreed)
    }
}