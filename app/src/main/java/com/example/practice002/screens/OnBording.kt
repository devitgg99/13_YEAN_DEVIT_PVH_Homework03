package com.example.practice002.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun OnBordingScreen(navHostController: NavHostController){
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.onbordingbackground),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column (modifier = Modifier.fillMaxWidth().fillMaxHeight(0.9f),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Bottom)
        {
            Image(
                painter = painterResource(id = R.drawable.carrotinbording),
                contentDescription = null,
                modifier = Modifier.width(100.dp).height(50.dp),
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Welcome \n to our store",
                fontFamily = Rubik,
                fontWeight = FontWeight.Normal,
                fontSize = 50.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
                lineHeight = 45.sp
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Get your groceries in as fast as one hour",
                fontFamily = Rubik,
                fontWeight = FontWeight.Light,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(30.dp))

            Button (
                onClick = { navHostController.navigate(Screen.AuthScreen.route) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenCustom,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp).height(50.dp),
                shape = ShapeDefaults.Medium
            ){
                Text(
                    text = "Get Started",
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Normal ,
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }
}