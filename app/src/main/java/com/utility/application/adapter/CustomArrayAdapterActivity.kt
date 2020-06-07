package com.utility.application.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.utility.application.adapter.model.MyData
import com.utility.application.R
import kotlinx.android.synthetic.main.custom_adapter.*

class CustomArrayAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_adapter)
        val dataList = ArrayList<MyData>()

        //creating a dataList of our custom objects
        for (i in 1..50)
            dataList.addAll(
                listOf(
                    MyData(
                        "swanand",
                        "behaviour",
                        "good"
                    ),
                    MyData(
                        "saurabh",
                        "management",
                        "roleModel"
                    )
                    ,
                    MyData(
                        "raja",
                        "technical",
                        "strong"
                    )
                )
            )

        //to show our complex data object we will need our own adapter

        //initializing the adapter
        val customAdapter = CustomArrayAdapter(
            this,
            0,
            dataList
        )

        //setting the adapter
        listView.adapter = customAdapter
    }
}