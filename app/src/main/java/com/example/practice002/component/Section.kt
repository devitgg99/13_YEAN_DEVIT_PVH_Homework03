package com.example.practice002.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice002.R
import com.example.practice002.ui.theme.GreenCustom

@Composable
fun Section(title:String, currentRoute: String?){
    if(title == "Exclusive Offer"){
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth().height(125.dp)
        )
    }
    Column (modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp).padding(horizontal = 20.dp, vertical = 10.dp).wrapContentHeight()){
        Row (modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
            Text(
                text = title,
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = "See all",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = GreenCustom,
            )
        }
        if(title == "Groceries"){
            LazyRow {
                items(4){
                    CustomGroceryCard()
                    Spacer(modifier = Modifier.width(20.dp))
                }
            }
            Spacer(modifier = Modifier.height(20.dp))

        }
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(5) {
                CustomCard(currentRoute)
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}