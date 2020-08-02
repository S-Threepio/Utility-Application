package com.utility.application.api

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.utility.application.api.retrofit.JokesApi
import com.utility.application.api.retrofit.RetrofitRepositoryImpl
import kotlinx.coroutines.*
import java.lang.Exception

class ApiViewModel : ViewModel() {

    val myJob = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + myJob)
    val retrofitRepository = RetrofitRepositoryImpl()
    val retrofit = retrofitRepository.get()
    var visibility = MutableLiveData<Boolean>()
    var joke = MutableLiveData<JokesModel>()

    init {
        fetchJoke()
    }

    fun fetchJoke() {
        uiScope.launch {
            try {
                //do on subscribe
                //a loader can be shown here
                visibility.value = true

                //api call which blocks the thread
                getJoke()

                //do on success block
                visibility.value = false
            } catch (e: Throwable) {
                //error block
                Log.d("api machine broke", e.message.toString())
            }
        }
    }

    suspend fun getJoke() {
        //we switch to a different thread since network call cannot be done main thread
        withContext(Dispatchers.IO) {

            joke.postValue(retrofit.create(JokesApi::class.java).getJoke().await())
        }
    }

    override fun onCleared() {
        super.onCleared()
        myJob.cancel()
    }
}