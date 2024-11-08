package com.learning.nycschools.utils

sealed interface DataState<out Result> {
    data object Loading : DataState<Nothing>
    data class Success<T>(val data: T) : DataState<T>
    data class Failure(val throwable: Throwable) : DataState<Nothing>
}