package com.ashutosh1234ojha.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavType
import androidx.navigation.navArgument


/**
 * Created by Ashutosh Ojha on 15,April,2022
 */
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(route = Screens.MainScreen.route) {

            MainScreen(navController = navController)
        }

        composable(
            route = Screens.DetailsScreen.route + "/{name}",
            arguments = listOf(navArgument(name = "name") {
                type = NavType.StringType
                defaultValue = "ashu"
                nullable = true
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("name")?.let { DetailsScreen(name = it) }

        }
    }
}


@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp),
        verticalArrangement = Arrangement.Center
    ) {

        TextField(value = text, onValueChange = { it ->
            text = it
        }, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { navController.navigate(Screens.DetailsScreen.withArgs(text)) }) {
            Text(text = "To Detail Screen")

        }
    }

}

@Composable
fun DetailsScreen(name: String) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {

        Text(text = name)
    }
}