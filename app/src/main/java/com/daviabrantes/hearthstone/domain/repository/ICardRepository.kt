package com.daviabrantes.hearthstone.domain.repository

import com.daviabrantes.hearthstone.domain.model.CardBO

interface ICardRepository {
    suspend fun getCards(filter: String): List<CardBO>
}
