package com.panzhiev.ui.base.bindings

import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

object SwipeRefreshLayoutBindings {
    @JvmStatic
    @BindingAdapter(value = ["onRefresh"])
    fun serSwipeRefreshListener(
        view: SwipeRefreshLayout,
        listener: SwipeRefreshLayout.OnRefreshListener
    ) {
        view.setOnRefreshListener(listener)
    }
}