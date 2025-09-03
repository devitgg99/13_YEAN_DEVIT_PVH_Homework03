package com.example.practice002.component

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice002.R
import com.example.practice002.navigation.Screen
import com.example.practice002.ui.theme.GreenCustom
@Composable
fun CustomCard(currentRoute: String?) {
    Card (
        modifier = Modifier.width(165.dp).wrapContentHeight().padding(horizontal = if (currentRoute == Screen.BeverageScreen.route) 10.dp else 0.dp, vertical = if (currentRoute == Screen.BeverageScreen.route) 10.dp else 0.dp),
        shape = ShapeDefaults.Large,
        border = BorderStroke(1.dp, Color.LightGray),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ){
        Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween){
            Image(
                painter = painterResource(id = R.drawable.redcarrot),
                contentDescription = null,
                modifier = Modifier.width(80.dp).height(80.dp).padding(vertical = 10.dp)
            )
            Column(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)) {
                Text(
                    text = "Organic Bananas",
                    fontSize = 18.sp,
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Text(
                    text = "7pcs, Priceg",
                    fontSize = 15.sp,
                    modifier = Modifier.fillMaxWidth().padding(top = 5.dp),
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            }
            Row(modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = "$7.99",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
                Surface (modifier = Modifier.width(40.dp).height(40.dp),
                    color = GreenCustom,
                    shape = ShapeDefaults.Large){
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.padding(5.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun CustomGroceryCard(){
    Card (
        modifier = Modifier.width(220.dp).height(100.dp),
        shape = ShapeDefaults.Large,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF8A44C).copy(alpha = 0.3f)
        )
    ) {
        Row (
            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(R.drawable.groceriespulse),
                contentDescription = null,
                modifier = Modifier.width(65.dp).height(165.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Pulse",
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}