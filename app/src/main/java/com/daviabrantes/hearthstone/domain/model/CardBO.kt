package com.daviabrantes.hearthstone.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardBO(
    var cardId : String = "-",
    var dbfId : Int = 0,
    var name : String = "-",
    var cardSet : String = "-",
    var type : String = "-",
    var health : Int = 0,
    var text : String = "-",
    var artist : String = "-",
    var playerClass : String = "-",
    var img : String? = "-",
    var imgGold : String = "-",
    var attack : Int = 0,
    var flavor : String = "-",
    var faction : String = "-",
    var rarity : String = "-",
    var cost : Int = 0
) : Parcelable