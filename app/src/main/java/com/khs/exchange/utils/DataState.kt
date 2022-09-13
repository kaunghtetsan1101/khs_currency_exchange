package com.khs.exchange.utils

sealed class DataState<out T:Any> {
    data class Success<T : Any> (val result : T) : DataState<T>()
    data class Error (val message : String?) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}