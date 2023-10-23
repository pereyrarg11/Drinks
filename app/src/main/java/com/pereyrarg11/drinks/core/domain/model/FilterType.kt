package com.pereyrarg11.drinks.core.domain.model

enum class FilterType(val queryParam: String) {
    ALCOHOL("a"),
    CATEGORY("c"),
    INGREDIENT("i"),
    UNKNOWN("")
}