package com.daviabrantes.hearthstone.data.model

import com.daviabrantes.hearthstone.domain.model.CardBO
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardResponse(
    @SerialName("cardId") val cardId: String = "",
    @SerialName("dbfId") val dbfId: Int = 0,
    @SerialName("name") val name: String = "",
    @SerialName("cardSet") val cardSet: String = "",
    @SerialName("type") val type: String = "",
    @SerialName("faction") val faction: String = "",
    @SerialName("rarity") val rarity: String = "",
    @SerialName("cost") val cost: Int = 0,
    @SerialName("attack") val attack: Int = 0,
    @SerialName("health") val health: Int = 0,
    @SerialName("text") val text: String = "",
    @SerialName("flavor") val flavor: String = "",
    @SerialName("artist") val artist: String = "",
    @SerialName("playerClass") val playerClass: String = "",
    @SerialName("img") val img: String = "",
    @SerialName("imgGold") val imgGold: String = "",
)

fun CardResponse.toDomain() = CardBO(
    cardId = this.cardId,
    dbfId = this.dbfId,
    name = this.name,
    cardSet = this.cardSet,
    type = this.type,
    faction = this.faction,
    rarity = this.rarity,
    cost = this.cost,
    attack = this.attack,
    health = this.health,
    text = this.text,
    flavor = this.flavor,
    artist = this.artist,
    playerClass = this.playerClass,
    img = this.img,
    imgGold = this.imgGold,
)