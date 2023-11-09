package com.pereyrarg11.drinks.core.domain.model

enum class FilterType(val param: String) {
    ALCOHOL("a"),
    CATEGORY("c"),
    INGREDIENT("i"),
    UNKNOWN("");

    companion object {
        fun findByParam(param: String): FilterType =
            values().firstOrNull { it.param.equals(param, true) } ?: UNKNOWN
    }
}
