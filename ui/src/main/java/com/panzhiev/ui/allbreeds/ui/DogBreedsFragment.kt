package com.panzhiev.ui.allbreeds.ui

import androidx.lifecycle.ViewModelProvider
import com.panzhiev.ui.R
import com.panzhiev.ui.allbreeds.viewmodel.DogBreedsNavigation
import com.panzhiev.ui.allbreeds.viewmodel.DogBreedsViewModel
import com.panzhiev.ui.base.BaseFragment
import com.panzhiev.ui.base.SimpleItemDecoration
import com.panzhiev.ui.base.ViewModelFactory
import com.panzhiev.ui.breeddetails.ui.BreedDetailsFragment
import com.panzhiev.ui.databinding.FragmentDogBreedsBinding
import kotlinx.android.synthetic.main.fragment_dog_breeds.*
import javax.inject.Inject

class DogBreedsFragment : BaseFragment<FragmentDogBreedsBinding>() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<DogBreedsViewModel>

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(DogBreedsViewModel::class.java)
    }

    override val layoutId = R.layout.fragment_dog_breeds

    override fun setupBinding(binding: FragmentDogBreedsBinding) {
        binding.vm = viewModel
    }

    override fun setupViews() {
        viewModel.observeNavigation(this) { navigateTo(it) }
        breedsRv.apply {
            adapter = DogBreedsAdapter { navigateTo(DogBreedsNavigation.BreedDetails(it)) }
            addItemDecoration(SimpleItemDecoration(context))
        }
    }

    private fun navigateTo(navigation: DogBreedsNavigation) {
        when (navigation) {
            is DogBreedsNavigation.BreedDetails -> {
                navController.navigate(
                    R.id.action_dogsBreedsFragment_to_breedDetailsFragment,
                    BreedDetailsFragment.getBundle(navigation.breed)
                )
            }
            is DogBreedsNavigation.Error ->
                showToast(getString(R.string.error_common))
        }
    }
}