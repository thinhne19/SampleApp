package com.example.simpleapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.simpleapp.ViewModel.AuthViewModel


@Composable
fun SignUp(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repassword by remember { mutableStateOf("") }
    val viewModel: AuthViewModel = viewModel()
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .background(brush = Brush.verticalGradient(
                colors = listOf(Color(0xFF343060), Color(0xFF482E5B))
            ))
            .fillMaxSize()
            .padding(20.dp),

    ){
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text("Register to get started", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Full Name", color = Color.White) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = CircleShape
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email", color = Color.White) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = CircleShape
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password", color = Color.White) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = CircleShape
            )

            OutlinedTextField(
                value = repassword,
                onValueChange = { repassword = it },
                label = { Text("Confirm Password", color = Color.White) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = CircleShape
            )

            Button(
                onClick = {
                    if (name.isNotBlank() && email.isNotBlank() && password == repassword && password.length >= 6) {
                        viewModel.registerUser(
                            email = email,
                            password = password,
                            onSuccess = {
                                Toast.makeText(context, "Đăng ký thành công!", Toast.LENGTH_SHORT).show()
                                navController.navigate("login")
                            },
                            onFailure = { error ->
                                Toast.makeText(context, "Lỗi: $error", Toast.LENGTH_SHORT).show()
                            }
                        )
                    } else {
                        Toast.makeText(context, "Thông tin không hợp lệ", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .height(60.dp)
            ) {
                Text("Sign Up", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            Text("Or Register With", color = Color.Gray, modifier = Modifier.padding(top = 20.dp))

            Row (
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
            ){
                IconButton(onClick = {}) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook),
                        contentDescription = "Login With Facebook"
                    )
                }
                IconButton(onClick = {}) {
                    Image(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Login With Google"
                    )
                }
                IconButton(onClick = {}) {
                    Image(
                        painter = painterResource(id = R.drawable.insta),
                        contentDescription = "Login With Instagram"
                    )
                }
            }

        }

        Row (
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "You already have an acco unt! ",
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 16.dp)
            )
            Text(
                text = "Login Now",
                color = Color(0xFFFFFFFF),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .clickable {
                    navController.popBackStack() // Go back to login
                }
            )
        }
    }
}
