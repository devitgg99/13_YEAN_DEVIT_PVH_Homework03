package com.example.practice002.navigation

sealed class Screen(val route:String){
    object AuthScreen:Screen("auth_screen")
    object OnBoardingScreen:Screen("onboarding_screen")
    object HomeScreen:Screen("home_screen")
    object ExploreScreen:Screen("explore_screen")
    object MyCartScreen:Screen("myCart_screen")
    object FavoriteScreen:Screen("favorite_screen")
    object BeverageScreen:Screen("beverage_screen")
    object ProfileScreen:Screen("profile_screen")
}