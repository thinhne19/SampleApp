package com.example.simpleapp.screen.components


import ColorSurface
import ColorTextPrimary
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.simpleapp.R
import com.example.simpleapp.screen.util.CityData

@Composable
fun ActionBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        ControlButton(navController = navController)
        LocationInfo(
            modifier = Modifier.padding(top = 10.dp),
            location = "Ho Chi Minh",
        )
        ProfileButton()
    }
}

@Composable
fun ControlButton(
    modifier: Modifier = Modifier,
    navController: NavHostController
){

    var taskMenuExpanded  by remember {mutableStateOf(false)}

    Surface (
        modifier = Modifier
            .size(40.dp),
        color = ColorSurface,
        shape = CircleShape
    ){
        Box(
            modifier = Modifier.fillMaxSize().clickable{taskMenuExpanded = true},
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = painterResource(R.drawable.apps),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
            )
        }
    }
    DropdownMenu(
        expanded = taskMenuExpanded,
        onDismissRequest = { taskMenuExpanded = false },
    ) {
        DropdownMenuItem(
            text = {Text("Home")},
            onClick = {
                taskMenuExpanded = false
            }
        )
        DropdownMenuItem(
            text = {Text("Weather")},
            onClick = {
                taskMenuExpanded = false

            }
        )
        DropdownMenuItem(
            text = { Text("Setting") },
            onClick = {
                taskMenuExpanded = false
                navController.navigate("setting")
            }
        )
        DropdownMenuItem(
            text = {Text("Logout")},
            onClick = {
                taskMenuExpanded = false
            }
        )
    }
}

@Composable
fun ProfileButton(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .border(
                width = 1.5.dp,
                color = ColorSurface,
                shape = CircleShape
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = null,
            modifier = modifier
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}

@Composable
fun LocationInfo(
    modifier: Modifier = Modifier,
    location: String
) {

    var showDialog by remember { mutableStateOf(false) }
    var currentLocation by remember { mutableStateOf(location) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
                Image(
                    painter = painterResource(id = R.drawable.location),
                    contentDescription = null,
                    modifier = Modifier
                        .height(24.dp)
                        .clickable{showDialog = true},
                    contentScale = ContentScale.Fit
                )

            Text(
                text = currentLocation,
                modifier = Modifier
                    .clickable{showDialog = true},
                style = MaterialTheme.typography.titleLarge,
                color = ColorTextPrimary,
                fontWeight = FontWeight.Bold,
            )

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = {showDialog = false},
                    title = {Text("Select City", style = MaterialTheme.typography.titleLarge)},
                    text = {
                        Column (
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ){
                            CityData.forEach {
                                city -> Row (
                                    modifier = Modifier.fillMaxWidth().clickable{
                                        currentLocation = city.name
                                        showDialog = false
                                    }
                                        .padding(vertical = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ){
                                    Text(
                                        text = city.name,
                                        style = MaterialTheme.typography.bodyLarge,
                                        fontWeight = if(city.name == currentLocation) FontWeight.Bold else FontWeight.Normal
                                    )
                            }
                            }
                        }
                    },
                    confirmButton = { },
                    dismissButton = {Button(onClick = {showDialog = false}) { Text("Cancel") }},
                )
            }
        }
    }
}