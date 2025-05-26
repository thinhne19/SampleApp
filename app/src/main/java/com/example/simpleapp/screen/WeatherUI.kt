package com.example.simpleapp.screen

import ColorBackground
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.simpleapp.screen.components.ActionBar
import com.example.simpleapp.screen.components.AirQuality
import com.example.simpleapp.screen.components.DailyForecast
import com.example.simpleapp.screen.components.WeeklyForecast



@Composable
fun WeatherPage(navController: NavHostController) {
    Scaffold (
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF343060), Color(0xFF482E5B))
                )
            ),
         containerColor = ColorBackground
    ){ paddings ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(paddings)
                .padding(
                    horizontal = 24.dp,
                    vertical = 10.dp
                )
        ){
            ActionBar(navController = navController)
            Spacer(
                modifier = Modifier.height(12.dp)
            )
            DailyForecast()
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            AirQuality()
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            WeeklyForecast()
        }
    }
}


