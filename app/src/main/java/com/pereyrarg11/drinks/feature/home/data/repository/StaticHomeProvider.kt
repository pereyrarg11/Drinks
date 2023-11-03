package com.pereyrarg11.drinks.feature.home.data.repository

import com.pereyrarg11.drinks.core.domain.model.FilterType
import com.pereyrarg11.drinks.feature.home.domain.model.HomeFilterModel
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionModel
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionType

/**
 * Static data to be shown in HomeScreen.
 * Useful for preview mode and first app version.
 */
object StaticHomeProvider {
    private fun getAllFilters(): List<HomeFilterModel> = listOf(
        HomeFilterModel(
            label = "Alcoholic",
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
            type = FilterType.ALCOHOL,
        ),
        HomeFilterModel(
            label = "Non Alcoholic",
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/xwqvur1468876473.jpg",
            type = FilterType.ALCOHOL,
        ),
        HomeFilterModel(
            label = "Optional Alcohol",
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg",
            type = FilterType.ALCOHOL,
        ),
        HomeFilterModel(
            label = "Cocktail",
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/rptuxy1472669372.jpg",
            type = FilterType.CATEGORY,
        ),
        HomeFilterModel(
            label = "Shake",
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/uvypss1472720581.jpg",
            type = FilterType.CATEGORY,
        ),
        HomeFilterModel(
            label = "Shot",
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/rtpxqw1468877562.jpg",
            type = FilterType.CATEGORY,
        ),
        HomeFilterModel(
            label = "Beer",
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/rwpswp1454511017.jpg",
            type = FilterType.CATEGORY,
        ),
        HomeFilterModel(
            label = "Coffee & Tea",
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/vqwptt1441247711.jpg",
            type = FilterType.CATEGORY,
        ),
        HomeFilterModel(
            label = "Gin",
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/gin.png",
            type = FilterType.INGREDIENT,
        ),
        HomeFilterModel(
            label = "Scotch",
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/scotch.png",
            type = FilterType.INGREDIENT,
        ),
        HomeFilterModel(
            label = "Brandy",
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/brandy.png",
            type = FilterType.INGREDIENT,
        ),
        HomeFilterModel(
            label = "Champagne",
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/champagne.png",
            type = FilterType.INGREDIENT,
        ),
        HomeFilterModel(
            label = "Tequila",
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/tequila.png",
            type = FilterType.INGREDIENT,
        ),
        HomeFilterModel(
            label = "Vodka",
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/vodka.png",
            type = FilterType.INGREDIENT,
        ),
        HomeFilterModel(
            label = "Kahlua",
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/kahlua.png",
            type = FilterType.INGREDIENT,
        ),
        HomeFilterModel(
            label = "Whiskey",
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/whiskey.png",
            type = FilterType.INGREDIENT,
        ),
        HomeFilterModel(
            label = "Cognac",
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/cognac-Small.png",
            type = FilterType.INGREDIENT,
        ),
        HomeFilterModel(
            label = "Pisco",
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/pisco.png",
            type = FilterType.INGREDIENT,
        ),
    )

    private fun getFiltersByType(filter: FilterType): List<HomeFilterModel> =
        getAllFilters().filter { it.type == filter }

    fun getSection(type: HomeSectionType): HomeSectionModel {
        return when (type) {
            HomeSectionType.ALCOHOL -> HomeSectionModel(
                label = "",
                filters = getFiltersByType(FilterType.ALCOHOL),
                type
            )

            HomeSectionType.CATEGORIES -> HomeSectionModel(
                label = "Categories",
                filters = getFiltersByType(FilterType.CATEGORY),
                type
            )

            HomeSectionType.INGREDIENTS -> HomeSectionModel(
                label = "Ingredients",
                filters = getFiltersByType(FilterType.INGREDIENT),
                type
            )

            HomeSectionType.UNKNOWN -> HomeSectionModel(
                label = "",
                filters = emptyList(),
                type
            )
        }
    }

    fun getAllSections(): List<HomeSectionModel> = listOf(
        getSection(HomeSectionType.ALCOHOL),
        getSection(HomeSectionType.CATEGORIES),
        getSection(HomeSectionType.INGREDIENTS),
    )
}