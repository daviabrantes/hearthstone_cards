package com.daviabrantes.hearthstone.domain.model

import com.daviabrantes.hearthstone.domain.model.CardBO
import kotlin.random.Random

object CardDummy {

    private fun getCardDummy() = CardBO(
        cardId = "",
        dbfId = Random.nextInt(),
        name = "",
        cardSet = "",
        type = "",
        faction = "",
        rarity = "",
        cost = Random.nextInt(),
        attack = Random.nextInt(),
        health = Random.nextInt(),
        text = "",
        flavor = "",
        artist = "",
        playerClass = "",
        img = "",
        imgGold = "",
    )

    fun getListCard() = listOf(getCardDummy())
}