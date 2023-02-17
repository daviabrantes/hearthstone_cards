package com.daviabrantes.hearthstone.di

import com.daviabrantes.hearthstone.util.Constants.Companion.API_KEY
import com.daviabrantes.hearthstone.util.Constants.Companion.HEADER_URL
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request?.newBuilder()
            ?.addHeader("x-rapidapi-host", HEADER_URL)
            ?.addHeader("x-rapidapi-key", API_KEY)
            ?.build()
        return chain.proceed(request)
    }
}