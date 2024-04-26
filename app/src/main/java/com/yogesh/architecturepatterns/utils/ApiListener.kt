package com.yogesh.architecturepatterns.utils

interface ApiListener {
    fun onSuccess(responseBody: Any, type: String)
    fun onFailure(message: String)
}