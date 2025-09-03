package com.example.practice002.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practice002.R
import com.example.practice002.navigation.Screen
import com.example.practice002.ui.theme.GreenCustom
import com.example.practice002.ui.theme.Rubik

@Composable
fun ExploreCard(navHost: NavHostController){
    Card(modifier = Modifier.fillMaxWidth(0.5f).height(250.dp).padding(horizontal = 10.dp, vertical = 10.dp),
        shape = ShapeDefaults.ExtraLarge,
        colors = CardDefaults.cardColors(
            containerColor = GreenCustom.copy(0.2f)
        ),
        border = BorderStroke(1.5.dp, GreenCustom),
        onClick = {
            navHost.navigate(Screen.BeverageScreen.route)
        }
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            ){
            Image(
                painter = painterResource(id = R.drawable.redcarrot),
                contentDescription = null,
                modifier = Modifier.width(80.dp).height(80.dp).align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Fresh Fruits & Vegetables",
                fontFamily = Rubik,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}