package com.example.practice002.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.practice002.component.Section
import com.example.practice002.ui.theme.GrayCustomBackground

@Composable
fun HomeScreen(currentRoute: String?){
    val SectionTitle = mutableListOf("Exclusive Offer","Best Selling","Groceries")
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = GrayCustomBackground)){
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(3){
                Section(SectionTitle[it], currentRoute)
            }
        }
    }
}
