package com.example.practice002.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
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
import com.example.practice002.ui.theme.Rubik

@Composable
fun TopBarCustom(modifier: Modifier, currentRoute: String?, navHost: NavHostController){
    Column(modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()){
        when (currentRoute) {
            Screen.HomeScreen.route -> {
                Image(
                    painter = painterResource(id = R.drawable.redcarrot),
                    contentDescription = null,
                    modifier = Modifier
                        .width(80.dp)
                        .height(40.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row (modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center){
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = null,
                        modifier = Modifier
                            .width(25.dp)
                            .height(25.dp)
                    )
                    Text(
                        text = "Cambodia, Phnom Penh",
                        fontFamily = Rubik,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }
            }
            Screen.ExploreScreen.route -> {
                Text(
                    text = "Find Products",
                    fontFamily = Rubik,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
            Screen.MyCartScreen.route -> {
                Text(
                    text = "My Cart",
                    fontFamily = Rubik,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.fillMaxWidth().height(60.dp),
                    textAlign = TextAlign.Center
                )
            }
            Screen.FavoriteScreen.route -> {
                Text(
                    text = "My Cart",
                    fontFamily = Rubik,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.fillMaxWidth().height(60.dp),
                    textAlign = TextAlign.Center
                )
            }
            Screen.BeverageScreen.route -> {
                Row (modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp).height(60.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    ){
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        modifier = Modifier
                            .width(23.dp)
                            .height(23.dp)
                            .clickable{
                                navHost.navigate(Screen.ExploreScreen.route)
                            }
                    )
                    Text(
                        text = "Beverage",
                        fontFamily = Rubik,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.height(60.dp),
                        textAlign = TextAlign.End
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.option),
                        contentDescription = null,
                        modifier = Modifier
                            .width(23.dp)
                            .height(23.dp)
                    )
                }
            }
            Screen.ExploreScreen.route, Screen.HomeScreen.route -> {
                SearchBar()
            }
        }
    }
}