package com.example.practice002.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice002.R
import com.example.practice002.ui.theme.GreenCustom
import com.example.practice002.ui.theme.Rubik

@Composable
fun OrderAcceptScreen(){
    Column(modifier = Modifier.fillMaxSize().padding(vertical = 70.dp),
        verticalArrangement = Arrangement.SpaceBetween){
        Column (modifier = Modifier.align(Alignment.CenterHorizontally).padding(top= 55.dp)){
            Image(
                painter = painterResource(id = R.drawable.accepticon),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 40.dp)
            )
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            Text(
                text = "Your Order has been\n" +
                        " accepted",
                modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                fontFamily = Rubik,
                fontSize = 28.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Medium
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Text(
                text = "Your items has been placcd and is on \n" +
                        "it’s way to being processed",
                modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                fontFamily = Rubik,
                fontSize = 16.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                lineHeight = 24.sp,
                color = Color.Gray.copy(0.8f)
            )
        }
        Column(){
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth().height(60.dp).padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = GreenCustom
                ),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(15.dp)
            ) {
                Text(
                    text = "Track Order",
                    fontFamily = Rubik,
                    fontSize = 18.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
                )
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth().height(60.dp).padding(horizontal = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color.Transparent
                ),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(15.dp)
            ) {
                Text(
                    text = "Back to home",
                    fontFamily = Rubik,
                    fontSize = 18.sp,
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
                )
            }
        }
    }
}