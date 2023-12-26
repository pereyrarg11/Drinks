package com.pereyrarg11.drinks.core.presentation.util

import com.pereyrarg11.drinks.core.presentation.model.DrinkUiItem

object StaticDisplayableProvider {
    fun getDrinks(): List<DrinkUiItem> = listOf(
        DrinkUiItem(
            label = UiText.PlainText("Cosmopolitan"),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/kpsajh1504368362.jpg",
            id = "17196"
        ),
        DrinkUiItem(
            label = UiText.PlainText("Mojito"),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/metwgh1606770327.jpg",
            id = "11000"
        ),
        DrinkUiItem(
            label = UiText.PlainText("155 Belmont"),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/yqvvqs1475667388.jpg",
            id = "15346"
        ),
        DrinkUiItem(
            label = UiText.PlainText("A True Amaretto Sour"),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/rptuxy1472669372.jpg",
            id = "17005"
        ),
        DrinkUiItem(
            label = UiText.PlainText("Abbey Martini"),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/2mcozt1504817403.jpg",
            id = "17223"
        ),
        DrinkUiItem(
            label = UiText.PlainText("Alice Cocktail"),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/qyqtpv1468876144.jpg",
            id = "12562"
        ),
        DrinkUiItem(
            label = UiText.PlainText("Aperol Spritz"),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/iloasq1587661955.jpg",
            id = "178325"
        ),
        DrinkUiItem(
            label = UiText.PlainText("Blueberry Mojito"),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/07iep51598719977.jpg",
            id = "178336"
        ),
    )
}
