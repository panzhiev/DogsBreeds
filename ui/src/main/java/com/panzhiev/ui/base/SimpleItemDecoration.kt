package com.panzhiev.ui.base

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.panzhiev.ui.R

private const val DEFAULT_WIDTH = 1f

class SimpleItemDecoration(
    context: Context,
    private val drawLastDivider: Boolean = false
) : RecyclerView.ItemDecoration() {

    private val paint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.colorDivider)
        strokeWidth = DEFAULT_WIDTH
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.top = if (parent.getChildAdapterPosition(view) == 0) 0 else DEFAULT_WIDTH.toInt()
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {

        val childCount = if (drawLastDivider) parent.childCount else parent.childCount - 1

        for (i in 0 until childCount) {
            val child = parent.getChildAt(i)
            c.drawLine(
                0f,
                child.bottom.toFloat(),
                parent.width.toFloat(),
                child.bottom.toFloat(),
                paint
            )
        }
    }
}