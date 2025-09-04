package com.example.practice002.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practice002.component.ExploreCard
import com.example.practice002.ui.theme.GrayCustomBackground

@Composable
fun ExploreScreen(navHost: NavHostController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = GrayCustomBackground)){
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(5.dp)
        ) {
            items(10) {
                ExploreCard(navHost)
            }
        }
    }
}