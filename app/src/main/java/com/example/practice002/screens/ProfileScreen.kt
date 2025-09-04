package com.example.practice002.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
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
import com.example.practice002.component.ProfileSection
import com.example.practice002.ui.theme.GreenCustom
import com.example.practice002.ui.theme.Rubik

@Composable
fun ProfileScreen(){
    Column {
        Row(modifier = Modifier.systemBarsPadding().fillMaxWidth().padding(vertical = 20.dp)) {
            Surface(
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Black
                ),
                shape = androidx.compose.foundation.shape.CircleShape,
                modifier = Modifier.padding(horizontal = 20.dp)
            ){
                Image(painter = painterResource(id = R.drawable.profile), contentDescription = null,
                    modifier = Modifier.size(70.dp))
            }
            Column(modifier = Modifier.height(70.dp),
                verticalArrangement = Arrangement.Center) {
                Row {
                    Text(
                        text = "Devitt",
                        fontSize = 24.sp,
                        fontFamily = Rubik,
                        fontWeight = FontWeight.SemiBold
                    )
                    Icon(
                        imageVector = Icons.Outlined.Create,
                        contentDescription = null,
                        tint = GreenCustom,
                        modifier = Modifier.padding(start = 5.dp).size(20.dp).align(Alignment.CenterVertically)
                    )
                }
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = "datasese@gmail.com",
                    fontSize = 18.sp,
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            }
        }
        Spacer(
            modifier = Modifier.height(1.dp).background(Color.LightGray.copy(0.5f)).fillMaxWidth()
        )
        ProfileSection()
    }
}