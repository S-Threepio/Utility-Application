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
        dataList.add(
            MyData(
                "swanand",
                "behaviour",
                "good"
            )
        )
        dataList.add(
            MyData(
                "saurabh",
                "management",
                "roleModel"
            )
        )
        dataList.add(
            MyData(
                "raja",
                "technical",
                "strong"
            )
        )
        dataList.add(
            MyData(
                "swanand",
                "behaviour",
                "good"
            )
        )
        dataList.add(
            MyData(
                "saurabh",
                "management",
                "roleModel"
            )
        )
        dataList.add(
            MyData(
                "raja",
                "technical",
                "strong"
            )
        )
        dataList.add(
            MyData(
                "swanand",
                "behaviour",
                "good"
            )
        )
        dataList.add(
            MyData(
                "saurabh",
                "management",
                "roleModel"
            )
        )
        dataList.add(
            MyData(
                "raja",
                "technical",
                "strong"
            )
        )
        dataList.add(
            MyData(
                "swanand",
                "behaviour",
                "good"
            )
        )
        dataList.add(
            MyData(
                "saurabh",
                "management",
                "roleModel"
            )
        )
        dataList.add(
            MyData(
                "raja",
                "technical",
                "strong"
            )
        )
        dataList.add(
            MyData(
                "swanand",
                "behaviour",
                "good"
            )
        )
        dataList.add(
            MyData(
                "saurabh",
                "management",
                "roleModel"
            )
        )
        dataList.add(
            MyData(
                "raja",
                "technical",
                "strong"
            )
        )
        dataList.add(
            MyData(
                "swanand",
                "behaviour",
                "good"
            )
        )
        dataList.add(
            MyData(
                "saurabh",
                "management",
                "roleModel"
            )
        )
        dataList.add(
            MyData(
                "raja",
                "technical",
                "strong"
            )
        )

        val customAdapter = CustomArrayAdapter(
            this,
            R.layout.activity_array_adapter,
            dataList
        )
        listView.adapter = customAdapter
    }
}