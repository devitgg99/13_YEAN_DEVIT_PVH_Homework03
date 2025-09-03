package com.example.practice002.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice002.R

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ProfileScreen(){
    Row {
        Image(painter = painterResource(id = R.drawable.profile), contentDescription = null)
    }
}