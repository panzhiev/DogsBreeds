package com.panzhiev.ui.breeddetails.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.panzhiev.ui.R
import com.panzhiev.ui.base.utils.load
import com.panzhiev.ui.databinding.ItemBreedImageBinding

class BreedImagesAdapter : ListAdapter<String, BreedImagesAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BreedImagesAdapter.ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_breed_image,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: BreedImagesAdapter.ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(private val binding: ItemBreedImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(url: String) {
            binding.breedIv.load(
                url,
                RequestOptions().apply {
                    diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    transform(CenterCrop())
                    placeholder(R.drawable.image_dog_placeholder)
                    error(R.drawable.image_dog_placeholder)
                }
            )
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) = false
        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = false
    }
}