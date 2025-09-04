package com.example.practice002.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice002.R
import com.example.practice002.ui.theme.GreenCustom
import com.example.practice002.ui.theme.Rubik
import com.example.practice002.utility.constantData.profileItems

@Composable
fun ProfileSection(){
    Column(modifier = Modifier.fillMaxWidth().wrapContentHeight()){
        profileItems.forEach {it ->
            Row(modifier = Modifier.fillMaxWidth().padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween){
                Row (modifier = Modifier.fillMaxWidth(0.8f)){
                    Icon(
                        painter = painterResource(it.second),
                        contentDescription = null,
                        tint = GreenCustom,
                        modifier = Modifier.size(20.dp).align(Alignment.CenterVertically)
                    )
                    Text(
                        text = it.first,
                        fontSize = 20.sp,
                        fontFamily = Rubik,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
                Icon(
                    painter = painterResource(R.drawable.back_arrow),
                    contentDescription = null,
                    tint = GreenCustom,
                    modifier = Modifier.padding(start = 20.dp).size(20.dp)
                )
            }
            Spacer(
                modifier = Modifier.height(1.dp).background(Color.LightGray.copy(0.5f)).fillMaxWidth()
            )
        }
    }
}