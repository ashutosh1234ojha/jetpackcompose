package com.ashutosh1234ojha.mvvm.presentation.ui.recipelist

/**
 * Created by Ashutosh Ojha on 21,March,2022
 */

enum class FoodCategory(val value: String) {
    CHICKEN("Chicken"),
    BEEF("Beef"),
    SOUP("Soup"),
    DESSERT("Dessert"),
    VEGETARIAN("Vegetarian"),
    MILK("Milk"),
    VEGAN("Vegan"),
    PIZZA("Pizza"),
    DONUT("Donut"),
}

fun getAllFoodCategories(): List<FoodCategory> {
    return listOf(
        FoodCategory.CHICKEN,
        FoodCategory.BEEF, FoodCategory.SOUP,
        FoodCategory.DESSERT, FoodCategory.VEGETARIAN, FoodCategory.MILK,
        FoodCategory.VEGAN, FoodCategory.PIZZA, FoodCategory.DONUT
    )
}

fun getFoodCategory(value: String): FoodCategory? {
    val map = FoodCategory.values().associateBy(FoodCategory::value)
    return map[value]
}