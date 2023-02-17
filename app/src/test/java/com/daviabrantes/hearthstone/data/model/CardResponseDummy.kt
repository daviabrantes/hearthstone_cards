package com.daviabrantes.hearthstone.data.model

import kotlin.random.Random

object CardResponseDummy {

    fun getListCardResponseDummy() = listOf(getCardResponseDummy())

    private fun getCardResponseDummy() = CardResponse(
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
}