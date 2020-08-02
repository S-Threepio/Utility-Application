package com.utility.application.api.retrofit

import com.utility.application.api.JokesModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface JokesApi {
    @GET("Programming")
    fun getJoke(@Query("type") typeName: String = "twopart"): Deferred<JokesModel>
}