package com.example.practice002.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice002.R
import com.example.practice002.navigation.Screen
import com.example.practice002.ui.theme.GreenCustom
import com.example.practice002.ui.theme.Rubik

@Composable
@Preview(showBackground = true)
fun CardCart(currentRoute: String? = null){
    var count by remember { mutableStateOf(1) }
    Spacer(modifier = Modifier.height(1.dp).fillMaxWidth().padding(horizontal = 20.dp).background(color = Color.Gray.copy(0.2f)))
    Box(modifier = Modifier.fillMaxWidth().height(140.dp)){
        Row (
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(vertical = 20.dp, horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Box(modifier = Modifier.fillMaxWidth(0.25f).wrapContentHeight()){
                Image(
                    painter = painterResource(id = R.drawable.redcarrot),
                    contentDescription = null,
                    modifier = Modifier.width(70.dp).height(70.dp)
                )
            }
            Column (modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center){
                Text(
                    text = "Bell Pepper Red",
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "1kg, Price",
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(10.dp))
                if(currentRoute == Screen.MyCartScreen.route){
                    Row(modifier = Modifier.fillMaxWidth().height(35.dp),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically){
                        Surface(
                            modifier = Modifier.width(40.dp).height(40.dp).clickable{
                                count --
                            },
                            shape = ShapeDefaults.Medium,
                            border = BorderStroke(1.dp, Color.LightGray)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.minus),
                                contentDescription = null,
                                tint = Color.LightGray,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                        Text(
                            text = count.toString(),
                            fontFamily = Rubik,
                            fontWeight = FontWeight.Normal,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Start,
                            color = Color.Gray,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )
                        Surface(
                            modifier = Modifier.width(40.dp).height(40.dp).clickable{
                                count++
                            },
                            color = GreenCustom,
                            shape = ShapeDefaults.Medium,
                            border = BorderStroke(1.dp, Color.LightGray)

                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.plus),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.padding(10.dp)
                            )
                        }
                    }
                }
            }

            Column (modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(bottom = 5.dp),
                verticalArrangement = if(currentRoute == Screen.MyCartScreen.route) Arrangement.SpaceBetween else Arrangement.Center,
                horizontalAlignment = Alignment.End){
                if(currentRoute == Screen.MyCartScreen.route){
                Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = Color.LightGray,
                        modifier = Modifier.width(30.dp).height(30.dp).align(Alignment.End)
                    )
                    }
                Text(
                    text = "$4.99",
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.wrapContentHeight()
                )
            }
        }
    }
}