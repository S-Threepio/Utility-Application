package com.utility.application.adapter

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.utility.application.R
import kotlinx.android.synthetic.main.normal_adapter.*

class NormalArrayAdapterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.normal_adapter)
        val dataList = listOf(
            "one",
            "two",
            "three",
            "four",
            "five",
            "one",
            "two",
            "three",
            "four",
            "five",
            "one",
            "two",
            "three",
            "four",
            "five",
            "one",
            "two",
            "three",
            "four",
            "five",
            "one",
            "two",
            "three",
            "four",
            "five"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
        normalListView.adapter = adapter
    }
}