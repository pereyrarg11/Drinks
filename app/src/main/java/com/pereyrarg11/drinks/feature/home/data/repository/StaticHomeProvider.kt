package com.pereyrarg11.drinks.feature.home.data.repository

import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.domain.model.FilterType
import com.pereyrarg11.drinks.core.presentation.util.UiText
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
            label = UiText.StringResource(R.string.title_alcoholic),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
            type = FilterType.ALCOHOL,
            query = "Alcoholic"
        ),
        HomeFilterModel(
            label = UiText.StringResource(R.string.title_non_alcoholic),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/xwqvur1468876473.jpg",
            type = FilterType.ALCOHOL,
            query = "Non_alcoholic"
        ),
        HomeFilterModel(
            label = UiText.StringResource(R.string.title_optional_alcohol),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg",
            type = FilterType.ALCOHOL,
            query = "Optional_alcohol"
        ),
        HomeFilterModel(
            label = UiText.StringResource(R.string.title_cocktail),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/rptuxy1472669372.jpg",
            type = FilterType.CATEGORY,
            query = "Cocktail"
        ),
        HomeFilterModel(
            label = UiText.StringResource(R.string.title_shake),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/uvypss1472720581.jpg",
            type = FilterType.CATEGORY,
            query = "Shake"
        ),
        HomeFilterModel(
            label = UiText.PlainText("Shot"),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/rtpxqw1468877562.jpg",
            type = FilterType.CATEGORY,
            query = "Shot"
        ),
        HomeFilterModel(
            label = UiText.StringResource(R.string.title_beer),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/rwpswp1454511017.jpg",
            type = FilterType.CATEGORY,
            query = "Beer"
        ),
        HomeFilterModel(
            label = UiText.StringResource(R.string.title_coffee_tea),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/vqwptt1441247711.jpg",
            type = FilterType.CATEGORY,
            query = "Coffee_/_Tea"
        ),
        HomeFilterModel(
            label = UiText.StringResource(R.string.title_gin),
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/gin.png",
            type = FilterType.INGREDIENT,
            query = "Gin"
        ),
        HomeFilterModel(
            label = UiText.StringResource(R.string.title_scotch),
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/scotch.png",
            type = FilterType.INGREDIENT,
            query = "Scotch"
        ),
        HomeFilterModel(
            label = UiText.PlainText("Brandy"),
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/brandy.png",
            type = FilterType.INGREDIENT,
            query = "Brandy"
        ),
        HomeFilterModel(
            label = UiText.StringResource(R.string.title_champagne),
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/champagne.png",
            type = FilterType.INGREDIENT,
            query = "Champagne"
        ),
        HomeFilterModel(
            label = UiText.PlainText("Tequila"),
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/tequila.png",
            type = FilterType.INGREDIENT,
            query = "Tequila"
        ),
        HomeFilterModel(
            label = UiText.PlainText("Vodka"),
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/vodka.png",
            type = FilterType.INGREDIENT,
            query = "Vodka"
        ),
        HomeFilterModel(
            label = UiText.PlainText("Kahlua"),
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/kahlua.png",
            type = FilterType.INGREDIENT,
            query = "Kahlua"
        ),
        HomeFilterModel(
            label = UiText.PlainText("Whiskey"),
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/whiskey.png",
            type = FilterType.INGREDIENT,
            query = "Whiskey"
        ),
        HomeFilterModel(
            label = UiText.PlainText("Cognac"),
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/cognac-Small.png",
            type = FilterType.INGREDIENT,
            query = "Cognac"
        ),
        HomeFilterModel(
            label = UiText.PlainText("Pisco"),
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/pisco.png",
            type = FilterType.INGREDIENT,
            query = "Pisco"
        ),
    )

    private fun getFiltersByType(filter: FilterType): List<HomeFilterModel> =
        getAllFilters().filter { it.type == filter }

    private fun getSection(type: HomeSectionType): HomeSectionModel {
        return when (type) {
            HomeSectionType.ALCOHOL -> HomeSectionModel(
                filters = getAlcoholFilters(),
                type = type
            )

            HomeSectionType.CATEGORIES -> HomeSectionModel(
                label = UiText.StringResource(R.string.title_categories),
                filters = getCategoryFilters(),
                type
            )

            HomeSectionType.INGREDIENTS -> HomeSectionModel(
                label = UiText.StringResource(R.string.title_ingredients),
                filters = getIngredientFilters(),
                type
            )

            HomeSectionType.UNKNOWN -> HomeSectionModel(
                filters = emptyList(),
                type = type
            )
        }
    }

    fun getAllSections(): List<HomeSectionModel> = listOf(
        getAlcoholSection(),
        getCategoriesSection(),
        getIngredientsSection(),
    )

    fun getAlcoholFilters(): List<HomeFilterModel> = getFiltersByType(FilterType.ALCOHOL)

    fun getCategoryFilters(): List<HomeFilterModel> = getFiltersByType(FilterType.CATEGORY)

    fun getIngredientFilters(): List<HomeFilterModel> = getFiltersByType(FilterType.INGREDIENT)

    fun getAlcoholSection(): HomeSectionModel = getSection(HomeSectionType.ALCOHOL)

    fun getCategoriesSection(): HomeSectionModel = getSection(HomeSectionType.CATEGORIES)

    fun getIngredientsSection(): HomeSectionModel = getSection(HomeSectionType.INGREDIENTS)
}