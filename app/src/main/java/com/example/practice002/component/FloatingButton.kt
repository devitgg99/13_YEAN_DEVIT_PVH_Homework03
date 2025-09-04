package com.example.practice002.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practice002.R
import com.example.practice002.navigation.Screen
import com.example.practice002.ui.theme.GrayCustom
import com.example.practice002.ui.theme.GreenCustom

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomFloatButton(
    navhostController: NavHostController,
    currentRoute: String? = null,
    showSheet: Boolean,
    setSheetState: (showSheet: Boolean) -> Unit
){
    FloatingActionButton(
        onClick = {
            if(showSheet && currentRoute == Screen.MyCartScreen.route){
                setSheetState(!showSheet)
                navhostController.navigate(Screen.OrderAcceptScreen.route)
            }else{
                when(currentRoute){
                    Screen.MyCartScreen.route -> {
                        setSheetState(!showSheet)
                    }
                }
            }
        },
        containerColor = if(currentRoute != Screen.ProfileScreen.route) GreenCustom else GrayCustom,
        contentColor = Color.White,
        modifier = Modifier.padding(horizontal = 20.dp),
        elevation = FloatingActionButtonDefaults.elevation(defaultElevation =
            if(currentRoute == Screen.ProfileScreen.route || currentRoute == Screen.MyCartScreen.route) 1.dp else 10.dp,
            pressedElevation = if(currentRoute == Screen.ProfileScreen.route) 0.dp else 10.dp),
    ){
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = if(currentRoute == Screen.MyCartScreen.route || currentRoute == Screen.FavoriteScreen.route) Arrangement.Center else Arrangement.Start
            ) {
            if(showSheet){
                Text(
                    text = "Place Order",
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                )
            }else{
                when(currentRoute){
                    Screen.MyCartScreen.route,Screen.FavoriteScreen.route, Screen.BeverageScreen.route -> {
                        Text(
                            text = when (currentRoute) {
                                Screen.MyCartScreen.route -> "Go to Checkout"
                                Screen.FavoriteScreen.route -> "Add All to Cart"
                                else -> {
                                    "Apply Filter"
                                }
                            },
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .fillMaxWidth(if (currentRoute == Screen.MyCartScreen.route || currentRoute == Screen.BeverageScreen.route) 0.82f else 0.65f)
                                .padding(start = if (currentRoute == Screen.MyCartScreen.route || currentRoute == Screen.BeverageScreen.route) 50.dp else 0.dp)
                        )
                        if (currentRoute == Screen.MyCartScreen.route) {
                            Text(
                                text = "10.5$",
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp,
                                modifier = Modifier
                                    .background(color = Color.Gray.copy(0.5f))
                                    .border(1.dp, Color.Gray)
                            )
                        }
                    }

                    else ->{
                        Icon(
                            painter = painterResource(id = R.drawable.logout),
                            contentDescription = "Back",
                            modifier = Modifier.padding(start = 20.dp),
                            tint = GreenCustom
                        )
                        Text(
                            text = "Log Out",
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp,
                            color = GreenCustom,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterVertically)
                                .fillMaxWidth(0.9f)
                        )
                    }
                }
            }
        }
    }
}
