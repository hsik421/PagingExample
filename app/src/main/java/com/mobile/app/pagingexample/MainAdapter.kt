package com.mobile.app.pagingexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter : PagedListAdapter<Int,MainAdapter.ViewHolder>(diffCallback){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView){
            item_main_text.text = getItem(position).toString()
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Int>() {
            override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean =
                oldItem == newItem
        }
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
}