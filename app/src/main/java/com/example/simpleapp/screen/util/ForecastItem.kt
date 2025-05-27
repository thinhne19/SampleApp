package com.example.simpleapp.screen.util


import com.example.simpleapp.R


data class ForecastItem(
    val image: Int,
    val dayOfWeek: String,
    val date: String,
    val temperature: String,
    val airQuality: String,
    val airQualityIndicatorColorHex: String,
    val isSelected: Boolean = false,
    val rielTemperature: String
)

val ForecastData = listOf(
    ForecastItem(
        image = R.drawable.img_clouds,
        dayOfWeek = "Mon",
        date = "12 Feb",
        rielTemperature = "21°",
        temperature = "26°",
        airQuality = "194",
        airQualityIndicatorColorHex = "#ff7676",
        isSelected = true
    ),
    ForecastItem(
        image = R.drawable.img_moon_stars,
        dayOfWeek = "Tue",
        date = "13 Feb",
        temperature = "18°",
        airQuality = "160",
        airQualityIndicatorColorHex = "#ff7676",
        rielTemperature = "15°",

    ),
    ForecastItem(
        image = R.drawable.img_thunder,
        dayOfWeek = "Wed",
        date = "14 Feb",
        temperature = "20°",
        airQuality = "40",
        airQualityIndicatorColorHex = "#2dbe8d",
        rielTemperature = "16°"
    ),
    ForecastItem(
        image = R.drawable.img_clouds,
        dayOfWeek = "Thu",
        date = "15 Feb",
        temperature = "20°",
        airQuality = "58",
        airQualityIndicatorColorHex = "#f9cf5f",
        rielTemperature = "17°"
    ),
    ForecastItem(
        image = R.drawable.img_sun,
        dayOfWeek = "Fri",
        date = "16 Feb",
        temperature = "34°",
        airQuality = "121",
        airQualityIndicatorColorHex = "#ff7676",
        rielTemperature = "30°"
    ),
    ForecastItem(
        image = R.drawable.img_rain,
        dayOfWeek = "Sat",
        date = "17 Feb",
        temperature = "28°",
        airQuality = "73",
        airQualityIndicatorColorHex = "#f9cf5f",
        rielTemperature = "26°"
    ),
    ForecastItem(
        image = R.drawable.img_thunder,
        dayOfWeek = "Sun",
        date = "18 Feb",
        temperature = "26°",
        airQuality = "15",
        airQualityIndicatorColorHex = "#2dbe8d",
        rielTemperature = "24°"
    )
)