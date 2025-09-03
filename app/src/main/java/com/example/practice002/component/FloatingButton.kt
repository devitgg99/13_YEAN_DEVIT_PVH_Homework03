package com.example.practice002.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice002.navigation.Screen
import com.example.practice002.ui.theme.GreenCustom

@Composable
fun CustomFloatButton(currentRoute: String? = null){
    FloatingActionButton(
        onClick = { /*TODO*/ },
        containerColor = GreenCustom,
        contentColor = Color.White,
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
    ){
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = if(currentRoute == Screen.MyCartScreen.route) Arrangement.End else Arrangement.End
            ) {
            Text(
                text = if(currentRoute == Screen.MyCartScreen.route) "Go to Checkout" else "Add All to Cart",
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                modifier = Modifier.align(alignment = Alignment.CenterVertically).fillMaxWidth(if(currentRoute == Screen.MyCartScreen.route) 0.5f else 0.65f)
            )
            if (currentRoute == Screen.MyCartScreen.route){
                Text(
                    text = "10.5$",
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(end = 20.dp).background(color = Color.Gray.copy(0.5f)).border( 1.dp, Color.Gray)
                )
            }
        }
    }
}
