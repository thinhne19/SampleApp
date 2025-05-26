package com.example.simpleapp

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simpleapp.ViewModel.AuthViewModel

@Composable
fun SignIn(navController: NavController) {
//    var list = listOf(1,2,3)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val viewModel: AuthViewModel = viewModel()
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .background(brush = Brush.verticalGradient(
                colors = listOf(Color(0xFF343060), Color(0xFF482E5B))
            ))
            .fillMaxSize()
            .padding(20.dp)
    ){
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Welcome back!",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "Glad to see you again!",
                fontSize = 32.sp,
                color = Color(0xFF8C7529),
                modifier = Modifier.padding(bottom = 32.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email", color = Color.White)},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = CircleShape,
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password", color = Color.White) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                shape = CircleShape
            )

            Text(
                "Forgot Password?",
                Modifier
                    .align(Alignment.End)
                    .clickable{},
                color = Color.Gray
            )

            Button(
                onClick = {
                    if (email.isNotBlank() && password.isNotBlank()) {
                        viewModel.login(
                            email = email,
                            password = password,
                            onSuccess = {
                                Toast.makeText(context, "Đăng nhập thành công", Toast.LENGTH_SHORT).show()
                                navController.navigate("weather")
                            },
                            onFailure = { error ->
                                Toast.makeText(context, "Lỗi: $error", Toast.LENGTH_LONG).show()
                            }
                        )
                    } else {
                        Toast.makeText(context, "Thông tin không hợp lệ", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .padding(top = 15.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                shape = CircleShape
            ) {
                Text("Login", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            Text("Or Login With", color = Color.Gray, modifier = Modifier.padding(top = 20.dp))

            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
            ){
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "Login With Facebook"
                    )
                }
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Login With Google"
                    )
                }
                IconButton(onClick = { }) {
                    Image(
                        painter = painterResource(id = R.drawable.insta),
                        contentDescription = "Login With Instagram"
                    )
                }
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Don't have an account? ", color = Color.Black)
            Text(
                text = "Register Now",
                color = Color(0xFFFFFFFF),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    navController.navigate("register")
                }
            )
        }
    }
}
