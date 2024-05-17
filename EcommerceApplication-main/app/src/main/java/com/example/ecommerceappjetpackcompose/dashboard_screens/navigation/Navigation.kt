package com.example.ecommerceappjetpackcompose.dashboard_screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerceappjetpackcompose.dashboard_screens.Dashboard
import com.example.ecommerceappjetpackcompose.dashboard_screens.tab_screens.*
import com.example.ecommerceappjetpackcompose.dashboard_screens.viewmodel.SharedViewModel

@Composable
fun Navigation(viewModel: SharedViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) {
            Dashboard(navController, viewModel)
        }
        composable(Screen.ProductDetailsScreen.route) {
            ProductDetailsScreen(navController, viewModel)
        }
        composable(Screen.AddToCartScreen.route) {
            AddToCartScreen(navController, viewModel)
        }
        composable(Screen.ThankYouScreen.route) {
            ThankYouScreen(navController, viewModel)
        }
        composable(Screen.FavoriteScreen.route) {
            FavoriteScreen(navController, viewModel)
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController)
        }
        composable(Screen.OrderHistoryScreen.route) {
            OrderHistoryScreen(navController, viewModel)
        }
    }
}