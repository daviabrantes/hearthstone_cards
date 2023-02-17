package com.daviabrantes.hearthstone.data.remote

import com.daviabrantes.hearthstone.data.model.CardResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface HearthstoneApi {

    @GET("cards/{getParameters}?locale=ptBR")
    suspend fun getCards(@Path("getParameters") filter: String): List<CardResponse>
}
