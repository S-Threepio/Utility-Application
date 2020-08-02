package com.utility.application.async

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.utility.application.R
import kotlinx.android.synthetic.main.activity_async.*
import kotlinx.coroutines.*
import java.sql.Ref


class AsyncActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        //this scope will handle the jobs running on ui thread
        val scope = CoroutineScope(Dispatchers.Main + Job())


        /*sleep for 10 seconds in background task*/
        scope.launch {
            textView2.text = "Hey lets start to Sleepppppp"

            //running an operation on IO thread makes it run in the background
            withContext(Dispatchers.IO) {
                Thread.sleep(10000)
            }
            textView2.text = "Hey That was a pretty good nap"
        }

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.labels_array, android.R.layout.simple_list_item_1
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerId.onItemSelectedListener = this
        spinnerId.adapter = adapter

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(
        adapterView: AdapterView<*>,
        view: View?,
        i: Int,
        l: Long
    ) {
        val spinnerLabel = adapterView.getItemAtPosition(i).toString()
        Toast.makeText(this, spinnerLabel, Toast.LENGTH_SHORT).show()
    }

}
