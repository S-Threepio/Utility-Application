package com.utility.application.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.utility.application.R
import kotlinx.android.synthetic.main.recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view)
        val dataList: ArrayList<String> = arrayListOf()
        for (i in 1 until 100)
            dataList.addAll(
                listOf(
                    "one", "two", "three", "four", "five"
                )
            )

        //used to set the layout manager
        //layout manager will manage how the views will be placed inside a recycler view
        recyclerView.layoutManager = LinearLayoutManager(this)

        //adapter wich will decide how to patch data into the recycler view
        recyclerView.adapter = NumbersAdapter(dataList = dataList)

        //Nested Scroll Layout is supposed to be used if we are putting recycler view is not the root layout
        //if nested scrolling is enabled then the functionality of recycler view will cease to exist
        //so we will manually make it off
        recyclerView.isNestedScrollingEnabled = false
    }
}