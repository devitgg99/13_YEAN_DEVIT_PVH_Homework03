package com.example.practice002.component

import androidx.compose.foundation.background
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practice002.R
import com.example.practice002.navigation.Screen
import com.example.practice002.ui.theme.GreenCustom
import com.example.practice002.ui.theme.Rubik
import com.example.practice002.utility.constantData.filters
import kotlin.collections.set

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(navhostController: NavHostController,currentRoute:String?,sheetState: SheetState, showSheet: Boolean, onDismissRequest: (showSheet: Boolean) -> Unit,onDrag: (showSheet: Boolean) -> Unit, setSheetState: (showSheet: Boolean) -> Unit){
    ModalBottomSheet(
        onDismissRequest = { onDismissRequest(showSheet) },
        sheetState = sheetState,
        dragHandle = {
            DragHandle(showSheet,currentRoute = currentRoute){
                onDrag(showSheet)
            }
        },
    ) {
        when(currentRoute){
            Screen.BeverageScreen.route -> FilterSection(navhostController,currentRoute,showSheet){
                setSheetState(showSheet)
            }
            Screen.MyCartScreen.route -> CheckOutSection(navhostController,currentRoute,showSheet){
                setSheetState(showSheet)
            }
        }
    }
}


@Composable
fun DragHandle(showSheet: Boolean,currentRoute:String?, onClick:(Boolean)->Unit = {}){
    Row (modifier = Modifier.fillMaxWidth().height(60.dp).padding(horizontal = 20.dp),
        horizontalArrangement = if(true) Arrangement.SpaceBetween else Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        if(currentRoute != Screen.MyCartScreen.route){
            Icon(
                painter = painterResource(id = R.drawable.close),
                contentDescription = null,
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .clickable{
                        onClick(showSheet)
                    }
            )
        }

        Text(
            text = if(currentRoute == Screen.MyCartScreen.route) "Checkout" else "Filters",
            fontFamily = Rubik,
            fontWeight = FontWeight.Medium,
            fontSize = 22.sp,
            modifier = Modifier.padding(end = 40.dp).fillMaxWidth(if(currentRoute == Screen.MyCartScreen.route) 0.33f else 0.9f),
            textAlign = TextAlign.Center
        )
        if(currentRoute == Screen.MyCartScreen.route){
            Icon(
                painter = painterResource(id = R.drawable.close),
                contentDescription = null,
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
                    .clickable{
                        onClick(showSheet)
                    }
            )
        }

    }
}

@Composable
fun FilterSection(navhostController: NavHostController,currentRoute: String, showSheet: Boolean, setSheetState: (showSheet: Boolean) -> Unit) {
    val checkedStates = remember {
        mutableStateMapOf<String, Boolean>()
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
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
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
        Spacer(modifier = Modifier.height(60.dp))
        CustomFloatButton(
            navhostController,
            currentRoute,
            showSheet = showSheet,
        ) { setSheetState(showSheet) }
    }
}

@Composable
fun CheckOutSection(
    navhostController: NavHostController,
    currentRoute: String,
    showSheet: Boolean,
    setSheetState: (showSheet: Boolean) -> Unit
){
    var checkoutItem = mutableListOf<Pair<String,String>>(
        Pair("Delivery", "Select Method"),Pair("Payment", "2"),Pair("Promo Code", "Pick discount"),
        Pair("Total Cost", "$13.97")
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.Start
    ) {
        checkoutItem.forEach { item ->
            Spacer(
                modifier = Modifier.height(1.dp).background(Color.LightGray.copy(0.5f)).fillMaxWidth()
            )
            Row (modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = item.first,
                    fontSize = 18.sp,
                    fontFamily = Rubik,
                    fontWeight = FontWeight.W500,
                    color = Color.Gray
                )
                Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.wrapContentHeight()){
                    Text(
                        text = item.second,
                        fontSize = 18.sp,
                        fontFamily = Rubik,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(end = 10.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.back_arrow),
                        contentDescription = null,
                    )
                }
            }
        }
        Spacer(
            modifier = Modifier.height(1.dp).background(Color.LightGray.copy(0.5f)).fillMaxWidth()
        )
        Text(
            text = buildAnnotatedString {
                append("By continuing you agree to our ")
                withStyle(style = SpanStyle(color = Color.Black)){
                    append("Terms of Service")
                }
                append("\nand")
                withStyle(style = SpanStyle(color = Color.Black)){
                    append(" Privacy Policy.")
                }
            },
            fontSize = 16.sp,
            fontFamily = Rubik,
            fontWeight = FontWeight.W400,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 15.dp)
        )
        CustomFloatButton(
            navhostController,
            currentRoute,
            showSheet = showSheet,
            setSheetState = { setSheetState(showSheet)},
        )
    }
}