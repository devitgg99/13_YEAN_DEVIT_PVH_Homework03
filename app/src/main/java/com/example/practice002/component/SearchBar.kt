package com.example.practice002.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice002.ui.theme.Rubik

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(){
    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    SearchBar(
        query = query,
        onQueryChange = { query = it },
        onSearch = { },
        active = active,
        onActiveChange = { active = it },
        placeholder = {
            Text(
                "Search Store",
                fontFamily = Rubik,
                fontSize = 16.sp,
            )
        },
        shape = ShapeDefaults.Medium,
        colors = SearchBarDefaults.colors(
            containerColor = Color.White
        ),
        leadingIcon = {
            Icon(
                Icons.Default.Search, contentDescription = null,
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

    }
}