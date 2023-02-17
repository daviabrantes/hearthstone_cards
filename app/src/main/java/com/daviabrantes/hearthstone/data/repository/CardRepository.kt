package com.daviabrantes.hearthstone.data.repository

import com.daviabrantes.hearthstone.data.model.toDomain
import com.daviabrantes.hearthstone.data.remote.HearthstoneApi
import com.daviabrantes.hearthstone.domain.model.CardBO
import com.daviabrantes.hearthstone.domain.repository.ICardRepository

class CardRepository(
    private val apiService: HearthstoneApi,
) : ICardRepository {

    override suspend fun getCards(filter: String): List<CardBO> {
        return apiService.getCards(filter).map { it.toDomain() }
    }
}