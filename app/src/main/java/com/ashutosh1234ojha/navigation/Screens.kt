package com.ashutosh1234ojha.navigation

/**
 * Created by Ashutosh Ojha on 15,April,2022
 */
sealed class Screens(val route: String) {
    object MainScreen : Screens("MainScreen")
    object DetailsScreen : Screens("DetailsScreen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }

        }
    }
}
