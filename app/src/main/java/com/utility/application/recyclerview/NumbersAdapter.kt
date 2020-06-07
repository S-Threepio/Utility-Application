package com.utility.application.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// the adapter of recycler view should be extending RecyclerView.Adapter<NumbersAdapter.NumbersViewHolder>

//pass the datalist which should contain the data to be shown
class NumbersAdapter(var dataList: ArrayList<String>) :
    RecyclerView.Adapter<NumbersAdapter.NumbersViewHolder>() {

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

    //returns number of items in the data
    override fun getItemCount(): Int {
        return dataList.size
    }

    //used to bind our data with the view holder
    //here we will assign our data to view
    override fun onBindViewHolder(holder: NumbersViewHolder, position: Int) {
        holder.textView.text = dataList[position]
    }
}