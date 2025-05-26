package com.example.simpleapp.screen.components

import ColorSurface
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simpleapp.R
import com.example.simpleapp.screen.util.AirQualityData
import com.example.simpleapp.screen.util.AirQualityItem
import kotlinx.coroutines.delay


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AirQuality(
    modifier: Modifier = Modifier,
    data: List<AirQualityItem> = AirQualityData
){
    Surface (
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        color = ColorSurface
    ){
        Column (
            modifier = Modifier.padding(
                vertical = 18.dp,
                horizontal = 24.dp,
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            AirQualityHeader()

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                maxItemsInEachRow = 3,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                data.onEach { item ->
                    AirQualityInfo(
                        data = item,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}


@Composable
private fun AirQualityHeader(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.outline_dew_point_24),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = Color(0xFF505CA6)
            )
            Text(
                text = "Air Quality",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 18.sp
                )
            )
        }
        RefreshButton()
    }
}


@Composable
private fun RefreshButton(
    modifier: Modifier = Modifier
) {
    var isRefreshing by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (isRefreshing) 360f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    Surface(
        color = ColorSurface,
        shape = CircleShape,
        modifier = modifier
            .size(32.dp)
            .clickable { isRefreshing = true },
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "RefreshButton",
                modifier = if(isRefreshing) Modifier.rotate(rotation) else Modifier,
                tint = Color(0xFF505CA6)
            )

            if(isRefreshing) {
                LaunchedEffect(Unit) {
                    delay(2000)
                    isRefreshing = false
                }
            }
        }
    }
}

@Composable
fun AirQualityInfo(
    modifier: Modifier,
    data: AirQualityItem
){
    Row (
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Icon(
            painter = painterResource(data.icon),
            contentDescription = null,
            modifier = Modifier.size(50.dp),
            tint = Color(0xFF505CA6)
        )
        Column (
            horizontalAlignment = Alignment.Start,
        ){
            Text(
                text = data.title,
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF000000)
            )

            Text(
                text = data.value,
                style = MaterialTheme.typography.labelSmall,
                color = Color(0xFF000000)
            )
        }
    }
}