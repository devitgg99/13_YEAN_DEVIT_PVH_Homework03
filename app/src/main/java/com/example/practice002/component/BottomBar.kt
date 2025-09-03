package com.example.practice002.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.practice002.R
import com.example.practice002.navigation.Screen
import com.example.practice002.ui.theme.GrayCustomBackground
import com.example.practice002.ui.theme.GreenCustom
import com.example.practice002.ui.theme.Rubik

@Composable
fun BottomBar(modifier: Modifier, navHost: NavHostController) {
    val items = listOf(
        "Shop" to R.drawable.shop,
        "Explore" to R.drawable.explore,
        "Cart" to R.drawable.cart,
        "Favorite" to R.drawable.favorite,
        "Account" to R.drawable.profile
    )
    val navBackStackEntry by navHost.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = GrayCustomBackground),
        color = Color.White,
        shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
        shadowElevation = 4.dp,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            items.forEachIndexed { index, item ->
                val isSelected = when (index) {
                    0 -> currentRoute == Screen.HomeScreen.route
                    1 -> currentRoute == Screen.ExploreScreen.route
                    2 -> currentRoute == Screen.MyCartScreen.route
                    3 -> currentRoute == Screen.FavoriteScreen.route
                    4 -> currentRoute == "account"
                    else -> false
                }

                val activeColor = GreenCustom
                val inactiveColor = Color.Gray

                Column(
                    modifier = Modifier.clickable {
                        when (index) {
                            0 -> navHost.navigate(Screen.HomeScreen.route)
                            1 -> navHost.navigate(Screen.ExploreScreen.route)
                            2 -> navHost.navigate(Screen.MyCartScreen.route)
                            3 -> navHost.navigate(Screen.FavoriteScreen.route)
                            4 -> navHost.navigate("account")
                        }
                    },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = item.second),
                        contentDescription = null,
                        tint = if (isSelected) activeColor else inactiveColor
                    )
                    Text(
                        text = item.first,
                        fontFamily = Rubik,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (isSelected) activeColor else inactiveColor
                    )
                }
            }
        }
    }
}