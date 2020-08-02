package com.utility.application.api.retrofit

interface Provider<T> {
    fun get(): T
}