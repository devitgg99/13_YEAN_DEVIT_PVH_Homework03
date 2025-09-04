package com.example.practice002.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.practice002.component.BottomBar
import com.example.practice002.component.CustomFloatButton
import com.example.practice002.component.TopBarCustom
import com.example.practice002.screens.AuthenSreen
import com.example.practice002.screens.BeverageScreen
import com.example.practice002.screens.ExploreScreen
import com.example.practice002.screens.FavoriteScreen
import com.example.practice002.screens.HomeScreen
import com.example.practice002.screens.MyCartScreen
import com.example.practice002.screens.OnBordingScreen
import com.example.practice002.screens.OrderAcceptScreen
import com.example.practice002.screens.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navHost = rememberNavController()
    val backStackEntry = navHost.currentBackStackEntryAsState()
    val currentRoute = backStackEntry.value?.destination?.route
    val allowedRoutes = listOf(
        Screen.MyCartScreen.route,
        Screen.FavoriteScreen.route,
        Screen.ProfileScreen.route
    )
    val sheetState = rememberModalBottomSheetState  (skipPartiallyExpanded = false)
    var showSheet by remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = {
            if (currentRoute != Screen.OnBoardingScreen.route &&
                currentRoute != Screen.AuthScreen.route
            ) {
                TopBarCustom(
                    modifier = Modifier, currentRoute, navHost, sheetState, showSheet,
                    setSheetState = {showSheet = !showSheet},
                )
            }
        },
        bottomBar = {
            if (currentRoute != Screen.OnBoardingScreen.route &&
                currentRoute != Screen.AuthScreen.route && currentRoute != Screen.BeverageScreen.route && currentRoute != Screen.OrderAcceptScreen.route
            ){
                BottomBar(modifier = Modifier, navHost)
            }
        },
        floatingActionButton = {
            if (currentRoute in allowedRoutes){
                CustomFloatButton(
                    navHost,
                    currentRoute,
                    showSheet = showSheet,
                ) { showSheet = !showSheet }
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {innerPadding ->
        NavHost(
            navController = navHost,
            startDestination = Screen.MyCartScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.OnBoardingScreen.route) {
                OnBordingScreen(navHost)
            }
            composable(Screen.AuthScreen.route) {
                AuthenSreen(navHost)
            }
            composable(Screen.HomeScreen.route) {
                HomeScreen(currentRoute)
            }
            composable(Screen.ExploreScreen.route) {
                ExploreScreen(navHost)
            }
            composable(Screen.MyCartScreen.route) {
                MyCartScreen(currentRoute)
            }
            composable(Screen.FavoriteScreen.route) {
                FavoriteScreen(currentRoute)
            }
            composable(Screen.BeverageScreen.route) {
                BeverageScreen(currentRoute)
            }
            composable(Screen.ProfileScreen.route) {
                ProfileScreen()
            }
            composable(Screen.OrderAcceptScreen.route) {
                OrderAcceptScreen()
            }
        }
    }
}

