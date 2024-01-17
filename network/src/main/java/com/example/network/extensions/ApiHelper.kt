package com.example.network.extensions

import com.example.core.model.GenericException
import retrofit2.Response

fun <T> Response<T>.handleResponse(): T {
    return try {
        this.takeIf { it.isSuccessful }?.body()!!
    } catch (e: Exception) {
        throw GenericException(
            message = e.message,
            hasUserFriendlyMessage = false
        )
    }
}

suspend fun <T> handleCall(block: suspend () -> Response<T>): T {
    return try {
        block.invoke().handleResponse()
    } catch (e: Exception) {
        throw GenericException(
            message = e.message,
            hasUserFriendlyMessage = false
        )
    }
}

