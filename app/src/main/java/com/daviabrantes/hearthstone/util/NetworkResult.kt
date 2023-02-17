package com.daviabrantes.hearthstone.util

import com.daviabrantes.hearthstone.presentation.model.CardVO

sealed class NetworkResult {
    object Loading : NetworkResult()
    data class Success(val cardVO: List<CardVO>) : NetworkResult()
    object Error : NetworkResult()
}
