package com.example.simpleapp.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpleapp.screen.util.ForecastData
import com.example.simpleapp.screen.util.ForecastItem
import kotlin.collections.List


@Preview(name = "weather", device = "id:pixel_9_pro", showSystemUi = true,
    showBackground = true
)
@Composable
fun WeatherDaily(
    modifier: Modifier = Modifier,
    data: List<ForecastItem> = ForecastData
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(
                colors = listOf(Color(0xFF4B476C), Color(0xFF8968A1))
            ))
    ) {
        HeaderTitle()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                items = data,
                key = { it.dayOfWeek }
            ) { item ->
                ShowDay(item = item)
            }
        }
    }
}

@Composable
fun HeaderTitle(
    modifier: Modifier = Modifier
) {
    Text(
        "WEEKLY WEATHER\nFORECAST",
        fontSize = 42.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 32.dp),
    )
}

@Composable
fun ShowDay(
    modifier: Modifier = Modifier,
    item: ForecastItem
){
    if (item.isSelected) {
        // Today - Full display like in the image
        TodayWeatherCard(item = item)
    } else
    {
        SimpleWeatherCard(item = item)
    }
}

@Composable
fun TodayWeatherCard(item: ForecastItem) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left side - Today label
            Column {
                Text(
                    text = item.date,
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Text(
                    text = item.dayOfWeek,
                    color = Color.White,
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Medium
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Right side - Temperature range
                Text(
                    text = item.rielTemperature+"-"+item.temperature,
                    color = Color.White,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Center - Weather icon
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Weather icon",
                modifier = Modifier.size(150.dp)
            )

        }
    }

@Composable
fun SimpleWeatherCard(item: ForecastItem) {
    OutlinedCard (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left side - Today label
            Column {
                Text(
                    text = item.date,
                    color = Color.Gray,
                    fontSize = 16.sp
                )
                Text(
                    text = item.dayOfWeek,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            // Center - Weather icon
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Weather icon",
                modifier = Modifier.size(80.dp)
            )

            // Right side - Temperature range
            Text(
                text = item.rielTemperature+"-"+item.temperature,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


