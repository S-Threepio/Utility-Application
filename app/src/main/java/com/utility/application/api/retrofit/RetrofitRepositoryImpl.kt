package com.utility.application.api.retrofit

import com.example.thankyoutree.retrofit.RetrofitProvider
import retrofit2.Retrofit

class RetrofitRepositoryImpl : Provider<Retrofit> {
    override fun get(): Retrofit = RetrofitProvider().get()
}