package com.pereyrarg11.drinks.feature.home.domain

import com.pereyrarg11.drinks.feature.home.domain.model.HomeFilterModel

object HomeUtils {
    fun getPreviewItems(): List<HomeFilterModel> = listOf(
        HomeFilterModel(
            "Alcoholic",
            "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg"
        ),
        HomeFilterModel(
            "Non Alcoholic",
            "https://www.thecocktaildb.com/images/media/drink/xwqvur1468876473.jpg"
        ),
        HomeFilterModel(
            "Optional Alcohol",
            "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg"
        ),
        HomeFilterModel(
            "Cocktail",
            "https://www.thecocktaildb.com/images/media/drink/rptuxy1472669372.jpg"
        ),
        HomeFilterModel(
            "Shake",
            "https://www.thecocktaildb.com/images/media/drink/uvypss1472720581.jpg"
        ),
        HomeFilterModel(
            "Shot",
            "https://www.thecocktaildb.com/images/media/drink/rtpxqw1468877562.jpg"
        ),
        HomeFilterModel(
            "Beer",
            "https://www.thecocktaildb.com/images/media/drink/rwpswp1454511017.jpg"
        ),
        HomeFilterModel(
            "Coffee / Tea",
            "https://www.thecocktaildb.com/images/media/drink/vqwptt1441247711.jpg"
        ),
    )
}