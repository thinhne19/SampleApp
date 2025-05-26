package com.example.simpleapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simpleapp.screen.WeatherPage
import com.example.simpleapp.screen.components.Setting



@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, name = "welcome", device = "id:pixel_9", showSystemUi = true)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "setting") {
        composable("welcome") { WelcomePage(navController) }
        composable("login") { SignIn(navController) }
        composable("register") {SignUp(navController)}
        composable ("weather"){ WeatherPage(navController) }
        composable ("setting"){ Setting(navController) }
    }
}

@Composable
fun WelcomePage(navController: NavHostController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(
                colors = listOf(Color(0xFF4B476C), Color(0xFF8968A1))
            ))
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image
        Image(
            painter = painterResource(id = R.drawable.weather_app),
            contentDescription = "Welcome Image",
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .size(300.dp, 450.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        // App Name
        Text(
            text = "Weather App",
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            modifier = Modifier.padding(top = 16.dp)

        )

        // Tagline
        Text(
            text = "ForeCasts",
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color(0xFF947D35),
            modifier = Modifier.padding(top = 8.dp)
        )

        // Button
        Button(
            onClick = { navController.navigate("login") },
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .padding(top = 50.dp)
                .fillMaxWidth(0.7f)
                .height(60.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF947D35))
        ) {
            Text("GET STARTED", style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3E376B),
                fontFamily = FontFamily.SansSerif
            )
            )
        }
    }
}
