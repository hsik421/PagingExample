package com.hackers.app.bigple.util

import android.graphics.Rect
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.View

/**
 * Created by admin on 2017-10-23.
 */
class SpacesItemDecoration(val spanCount : Int,val spacing : Int) : RecyclerView.ItemDecoration(){
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount

        outRect.left = spacing - column * spacing / spanCount
        outRect.right = (column + 1) * spacing / spanCount

        if (position < spanCount) {
            outRect.top = spacing
        }
        outRect.bottom = spacing
    }
}