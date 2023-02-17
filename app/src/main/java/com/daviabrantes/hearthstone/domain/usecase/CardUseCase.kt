package com.daviabrantes.hearthstone.domain.usecase

import com.daviabrantes.hearthstone.domain.model.CardBO
import com.daviabrantes.hearthstone.domain.repository.ICardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CardUseCase(
    private val repository: ICardRepository
) {
    fun getCards(filter: String): Flow<List<CardBO>> = flow {
        val response = repository.getCards(filter)
        emit(response)
    }
}