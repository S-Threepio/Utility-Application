package com.utility.application.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.utility.application.adapter.model.MyData
import com.utility.application.R
import kotlinx.android.synthetic.main.list_item_layout.view.*

class CustomArrayAdapter(context: Context, layout: Int, myList: ArrayList<MyData>) :
    ArrayAdapter<MyData>(context, layout, myList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.list_item_layout, parent, false
        )
        val currentData = getItem(position)
        view.first.text = currentData?.firstData
        view.second.text = currentData?.secondData
        view.third.text = currentData?.thirdData

        return view

    }


}