package com.example.practice002.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.practice002.component.CardCart
import com.example.practice002.ui.theme.GrayCustomBackground

@Composable
fun MyCartScreen(currentRoute: String? = null){
    LazyColumn (modifier = Modifier
        .fillMaxSize()
        .background(color = GrayCustomBackground)){
        items(15){
            CardCart(currentRoute)
        }
    }
}