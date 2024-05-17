package com.example.ecommerceappjetpackcompose.dashboard_screens.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object ProductDetailsScreen : Screen("product_details_screen")
    object AddToCartScreen : Screen("add_to_cart_screen")
    object ThankYouScreen : Screen("ThankYouScreen")
    object FavoriteScreen : Screen("FavoriteScreen")
    object ProfileScreen : Screen("ProfileScreen")
    object OrderHistoryScreen : Screen("OrderHistoryScreen")
}
