package com.utility.application.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

// the adapter of recycler view should be extending RecyclerView.Adapter<NumbersAdapter.NumbersViewHolder>

//pass the datalist which should contain the data to be shown
class NumbersAdapter(private val numberClick: NumberClickListener) :
    ListAdapter<String, NumbersAdapter.NumbersViewHolder>(NumbersDiffUtils()) {

    //we need a View Holder which will hold all the views defined
    class NumbersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView = itemView as TextView
    }

    //this method will create our view holder so we need to pass it the view
    //for now we are using the android's pre defined simple_list_item layout
    //you can create your own and pass it
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersViewHolder {
        //LayoutInflater class will get us a view object from a layout
        return NumbersViewHolder(
            LayoutInflater.from(parent.context).inflate(
                android.R.layout.simple_list_item_1,
                parent,
                false
            )
        )
    }

    //used to bind our data with the view holder
    //here we will assign our data to view
    override fun onBindViewHolder(holder: NumbersViewHolder, position: Int) {
        holder.textView.text = getItem(
            position
        )
        holder.textView.setOnClickListener {
            numberClick.onClick(getItem(position))
        }
    }
}

class NumbersDiffUtils : ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem === newItem
    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
}

class NumberClickListener(val clickListener: (number: String) -> Unit) {

    fun onClick(number: String) = clickListener(number)
}