package com.example.practice002.screens

import android.util.Log
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import com.example.practice002.R
import com.example.practice002.navigation.Screen
import com.example.practice002.ui.theme.GreenCustom
import com.example.practice002.ui.theme.Rubik
import com.example.practice002.utility.CustomPasswordVisualTransformation
@Composable
fun AuthenSreen(navHostController: NavHostController){
    val emailRegex = Patterns.EMAIL_ADDRESS
    val passwordRegex = Regex("^(?=.*[0-9]).{6,}$")
    var isLogin by remember { mutableStateOf(true) }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf(false) }
    var isPasswordVisible by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.authenticationbackground),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.fillMaxSize().padding(top = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top){
            Image(
                painter = painterResource(id = R.drawable.redcarrot),
                contentDescription = null,
                modifier = Modifier.width(120.dp).height(70.dp)
            )
            Spacer(modifier = Modifier.height(if (!isLogin) 100.dp else 120.dp))
            Text(
                text = if (isLogin) "Logging" else "Sign Up",
                modifier = Modifier.align(Alignment.Start).padding(horizontal = 20.dp),
                fontFamily = Rubik,
                fontWeight = FontWeight.Medium,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = if (isLogin) "Enter your emails and password" else "Enter your credentials to continue",
                modifier = Modifier.align(Alignment.Start).padding(horizontal = 20.dp),
                fontFamily = Rubik,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = Color.Gray,
            )
            if(!isLogin){
                OutlinedTextField(
                    value = username ?: "",
                    onValueChange = {username = it},
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                    label = {
                        Text(text = "Username")
                    },
                    supportingText = {
                        Text(text = "This is error")
                    }

                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedTextField(
                singleLine = true,
                value = email,
                onValueChange = {email = it},
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                label = {
                    Text(text = "Email")
                },
                isError = emailError,
                supportingText = {
                    if (emailError) {
                        Text(
                            text = "Invalid email address",
                            color = Color.Red,
                            fontSize = 16.sp
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = password,
                onValueChange = {password = it},
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                label = {
                    Text(text = "Password")
                },
                trailingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.eyes),
                        contentDescription = null,
                        modifier = Modifier.width(20.dp).height(20.dp).clickable{
                            isPasswordVisible = !isPasswordVisible
                        }
                    )
                },
                visualTransformation = if (isPasswordVisible) VisualTransformation.None else CustomPasswordVisualTransformation(mask = '•', fontSize = 24, letterSpacing = 0.6f)
            )
            Spacer(modifier = Modifier.height(10.dp))
            if(isLogin){
                Text(
                    text = "Forgot Password?",
                    modifier = Modifier.align(Alignment.End).padding(horizontal = 20.dp),
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            if(!isLogin){
                Text(
                    buildAnnotatedString {
                        append("By continuing you agree to our ")
                        withStyle(style = SpanStyle(color = GreenCustom)){
                            append("Terms of Service")
                        }
                        append("\nand")
                        withStyle(style = SpanStyle(color = GreenCustom)){
                            append(" Privacy Policy.")
                        }

                    },
                    modifier = Modifier.align(Alignment.Start).padding(horizontal = 20.dp),
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Start,
                    color = Color.Gray,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button (
                onClick = {
                    if (!emailRegex.matcher(email).matches()) {
                        emailError = true
                    } else if (!passwordRegex.matches(password)) {
                        passwordError = true
                    } else {
                        Log.d("AuthenticationScreen", "Username: $username, Email: $email, Password: $password")
                        emailError = false
                        passwordError = false
                        navHostController.navigate(Screen.HomeScreen.route)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = GreenCustom,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp).height(50.dp),
                shape = ShapeDefaults.Medium
            ){
                Text(
                    text = "Log In",
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Normal ,
                    fontSize = 17.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(
                    text = "Don't have an account?",
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                )
                Text(
                    text = " Sign Up",
                    fontFamily = Rubik,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = GreenCustom,
                    modifier = Modifier.clickable{
                        isLogin = !isLogin
                        username = ""
                        email = ""
                        password = ""
                    }
                )
            }

        }
    }
}

@Preview
@Composable
fun AuthenSreenPreview() {
    val navHostController = rememberNavController()
    AuthenSreen(navHostController)
}

