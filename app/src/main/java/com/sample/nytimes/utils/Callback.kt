package com.sample.nytimes.utils

interface Callback<T> {
    fun onResult(data: T)
    fun onError(error: String)
}