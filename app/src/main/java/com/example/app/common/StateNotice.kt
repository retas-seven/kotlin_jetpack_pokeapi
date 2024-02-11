package com.example.app.common

sealed class StateNotice <T>(
    val data: T? = null,
    val error: String? = null,
) {
    class Loading<T> : StateNotice<T>()
    class Success<T>(data: T) : StateNotice<T>(data = data)
    class Failure<T>(error: String) : StateNotice<T>(error = error)
}
