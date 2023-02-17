package com.daviabrantes.hearthstone.util

enum class Filter(val filterType: String, val filterName: String) {
    DRUID("classes/Druid", "Druid"),
    HUNTER("classes/Hunter", "Hunter"),
    WEAPON("types/Weapon", "Weapon"),
    SPELL("types/Spell", "Spell"),
    COMMON("qualities/Common", "Common"),
    EPIC("qualities/Epic", "Epic"),
}