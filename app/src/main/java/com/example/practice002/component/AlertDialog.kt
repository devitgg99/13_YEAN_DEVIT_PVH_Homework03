package com.example.practice002.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice002.R
import com.example.practice002.ui.theme.GreenCustom
import com.example.practice002.ui.theme.Rubik

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomAlertDialog(){
//    var visible by remember { mutableStateOf(true) }
//    Dialog(
//        onDismissRequest = { visible = false },
//    ) {
        Column(modifier = Modifier.fillMaxSize().padding(40.dp)){
            Icon(
                painter = painterResource(id = R.drawable.close),
                contentDescription = null,
                tint = Color.Black,
            )
            Image(
                painter = painterResource(id = R.drawable.error),
                contentDescription = null,
                modifier = Modifier.size(250.dp).align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Something went tembly wrong.",
                modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                fontFamily = Rubik,
                fontSize = 18.sp,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Normal,
                color = Color.Gray.copy(0.8f),
            )
            Column(){
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth().height(60.dp).padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = GreenCustom
                    ),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(15.dp)
                ) {
                    Text(
                        text = "Please Try Again",
                        fontFamily = Rubik,
                        fontSize = 18.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.align(Alignment.CenterHorizontally).fillMaxWidth().height(60.dp).padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.Transparent
                    ),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(15.dp)
                ) {
                    Text(
                        text = "Back to home",
                        fontFamily = Rubik,
                        fontSize = 18.sp,
                        fontWeight = androidx.compose.ui.text.font.FontWeight.Medium,
                    )
                }
            }
        }
//    }
}