package com.daviabrantes.hearthstone.di

import com.daviabrantes.hearthstone.data.remote.HearthstoneApi
import com.daviabrantes.hearthstone.util.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitSetup {

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(RequestInterceptor())
            .build()
    }

    fun provideGetService(retrofit: Retrofit): HearthstoneApi =
        retrofit.create(HearthstoneApi::class.java)
}