package com.example.simpleapp.screen.util



import androidx.annotation.DrawableRes
import com.example.simpleapp.R

data class AirQualityItem(
    val icon: Int,
    val title: String,
    val value: String
)

val AirQualityData = listOf(
    AirQualityItem(
        title = "Real Feel",
        value = "23.8",
        icon = R.drawable.outline_dew_point_24
    ),
    AirQualityItem(
        title = "Wind",
        value = "9km/h",
        icon = R.drawable.outline_air_24,
    ),
    AirQualityItem(
        title = "SO2",
        value = "0.9",
        icon = R.drawable.outline_dew_point_24
    ),
    AirQualityItem(
        title = "Rain",
        value = "68%",
        icon = R.drawable.outline_dew_point_24
    ),
    AirQualityItem(
        title = "UV Index",
        value = "3",
        icon = R.drawable.moon
    ),
    AirQualityItem(
        title = "FOЗ",
        value = "50",
        icon = R.drawable.outline_dew_point_24
    )
)