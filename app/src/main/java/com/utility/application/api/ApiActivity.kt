package com.utility.application.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.thankyoutree.retrofit.RetrofitProvider
import com.utility.application.R
import com.utility.application.api.retrofit.JokesApi
import com.utility.application.api.retrofit.RetrofitRepositoryImpl
import com.utility.application.databinding.ActivityApiBinding
import kotlinx.coroutines.*
import retrofit2.Retrofit
import java.lang.Exception

class ApiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(ApiViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_api)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.visibility.observe(this, Observer {
            binding.textView3.visibility = if (it) View.VISIBLE else View.GONE
        })
    }
}