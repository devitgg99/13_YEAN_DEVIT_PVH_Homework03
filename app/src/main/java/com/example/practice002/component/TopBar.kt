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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.practice002.R
import com.example.practice002.navigation.Screen
import com.example.practice002.ui.theme.GreenCustom
import com.example.practice002.ui.theme.Rubik
import com.example.practice002.utility.constantData.filters

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarCustom(modifier: Modifier, currentRoute: String?, navHost: NavHostController){
    val sheetState = rememberModalBottomSheetState  (skipPartiallyExpanded = false)
    var showSheet by remember { mutableStateOf(false) }
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
                            .clickable{
                                showSheet = true
                            }
                    )
                }
            }
            Screen.ExploreScreen.route, Screen.HomeScreen.route -> {
                SearchBar()
            }
        }
    }
    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false },
            sheetState = sheetState,
            dragHandle = {
                DragHandle()
            },
        ) {
            val checkedStates = remember {
                mutableStateMapOf<String, Boolean>()
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(LocalConfiguration.current.screenHeightDp.dp / 2)
                    .padding(20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                filters.forEach { filter ->
                    Text(
                        text = filter.filterName,
                        fontSize = 24.sp,
                        fontFamily = Rubik,
                        fontWeight = FontWeight.W500,
                        modifier = Modifier.wrapContentHeight().padding(bottom = 20.dp)
                    )
                    filter.filterItem.forEach { item ->
                        val isChecked = checkedStates[item] ?: false
                        Row(
                            modifier = Modifier.wrapContentHeight().fillMaxWidth()
                                .padding(bottom = 5.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Checkbox(
                                checked = isChecked,
                                onCheckedChange = { checkedStates[item] = it },
                                colors = CheckboxDefaults.colors(
                                    checkedColor = GreenCustom,
                                    uncheckedColor = Color.Black
                                ),
                                modifier = Modifier.padding(end = 10.dp).width(20.dp).height(20.dp)
                                    .clip(
                                        shape = ShapeDefaults.Medium
                                    )
                            )
                            Text(
                                text = item,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = if (isChecked) GreenCustom else Color.Black,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }

            }
        }
    }
}

@Composable
fun DragHandle(){
    Row (modifier = Modifier.fillMaxWidth().height(60.dp).padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
        ){
        Icon(
            painter = painterResource(id = R.drawable.close),
            contentDescription = null,
            modifier = Modifier
                .width(20.dp)
                .height(20.dp)
        )
        Text(
            text = "Filters",
            fontFamily = Rubik,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            modifier = Modifier.fillMaxWidth().padding(end = 20.dp),
            textAlign = TextAlign.Center
        )

    }
}
