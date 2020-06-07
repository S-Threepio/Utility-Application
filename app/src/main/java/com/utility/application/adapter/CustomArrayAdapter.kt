package com.utility.application.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.utility.application.adapter.model.MyData
import com.utility.application.R
import kotlinx.android.synthetic.main.list_item_layout.view.*

//our adapter should extend the ArrayAdapter
class CustomArrayAdapter(context: Context, layout: Int, myList: ArrayList<MyData>) :
    ArrayAdapter<MyData>(context, layout, myList) {

    //this method will fetch the view

    //we will override it to set our own data
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        //convertView will get us the old view if its reusable otherwise we will create anew one using LayoutInflater
        //LayoutInflater can create a view from the supplied layout file
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.list_item_layout, parent, false
        )

        //setting the data to our view for each item
        val currentData = getItem(position)
        view.first.text = currentData?.firstData
        view.second.text = currentData?.secondData
        view.third.text = currentData?.thirdData

        return view

    }


}