package com.daviabrantes.hearthstone.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daviabrantes.hearthstone.domain.usecase.CardUseCase
import com.daviabrantes.hearthstone.presentation.model.CardVO
import com.daviabrantes.hearthstone.util.NetworkResult
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CardViewModel(private val cardUseCase: CardUseCase) : ViewModel() {

    private val _cardsResponse = MutableStateFlow<NetworkResult>(NetworkResult.Loading)
    val cardsResponse: StateFlow<NetworkResult> = _cardsResponse

    fun getCards(filter: String) {

        viewModelScope.launch {

            cardUseCase.getCards(filter)
                .onStart {
                    _cardsResponse.value = NetworkResult.Loading
                }
                .catch {
                    _cardsResponse.value = NetworkResult.Error
                }
                .collect {
                    val cardList = it.map { cards -> CardVO(cards) }
                    _cardsResponse.value = NetworkResult.Success(cardVO = cardList)
                }

        }
    }
}
