package com.example.simpleapp.screen.components



import ColorBackground
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.simpleapp.R
import androidx.core.content.edit
import com.example.simpleapp.screen.util.themes
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun Setting(navController: NavHostController) {
    BackButton()
}

@Preview(name = "setting", device = "id:pixel_8a", showBackground = true, showSystemUi = true)
@Composable
fun BackButton(
    modifier: Modifier = Modifier
){

    val context = LocalContext.current
    var themeIndex by remember { mutableStateOf(getSavedThemeIndex(context)) }
    val gradientColors = themes.getOrNull(themeIndex)?.colors ?: themes[0].colors

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = gradientColors
                )
            ),
        containerColor = ColorBackground
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
        ) {
            Row (
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(onClick = {  }) {
                    Image(
                        painter = painterResource(id = R.drawable.left_arrow),
                        contentDescription = "Backleftarrow",
                        Modifier.size(24.dp)
                    )
                }

                Text(
                    "Settings",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    color = Color.Black,
                )
            }
            Avatar()
            Spacer(modifier = Modifier.height(12.dp))
            Spacer(modifier = Modifier.height(12.dp))
            ChangeTheme(
                currentIndex = themeIndex,
                onThemeChange = {
                    themeIndex = it
                    saveThemeIndex(context, it)
                }
            )
            Infomation()
        }
    }
}

@Composable
fun Avatar(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Avatar",
            modifier = modifier
                .clip(CircleShape)
                .size(100.dp)
                .border(2.dp, Color.White, CircleShape)
        )

        Text(
            text = "Username",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}


fun saveThemeIndex(context: Context, index: Int) {
    val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    prefs.edit { putInt("theme_index", index) }
    Log.d("Settings", "Saved theme index: $index")  // Dòng log này in ra logcat
}


fun getSavedThemeIndex(context: Context): Int {
    val prefs = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    return prefs.getInt("theme_index", 0)
}


@Composable
fun ChangeTheme(
    currentIndex: Int,
    onThemeChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(vertical = 16.dp)) {
        Text(
            "Change Theme",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        themes.forEachIndexed { index, theme ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = currentIndex == index,
                    onClick = { onThemeChange(index) }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = theme.name, color = Color.White)
            }
        }
    }
}

@Composable
fun Infomation(
    modifier: Modifier = Modifier
){

    Text(
        "Infomation",
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color.Black
    )

    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        // Account
        IconSetting(
            icon = Icons.Default.Person,
            title = "Account",
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Notifications
        IconSetting(
            icon = Icons.Default.Notifications,
            title = "Notifications",
        )

        Spacer(modifier = Modifier.height(8.dp))

// Privacy & Security
        IconSetting(
            icon = Icons.Default.Info,
            title = "Privacy & Security",
        )


        Spacer(modifier = Modifier.height(8.dp))

// About
        IconSetting(
            icon = Icons.Default.Face,
            title = "About",
        )
    }
}


@Composable
fun IconSetting(
    icon: ImageVector,
    title : String,
    modifier: Modifier = Modifier
){
    Row (
        modifier = modifier
            .fillMaxWidth()
            .clickable {  }
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = title,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Navigate",
            tint = Color.Black
        )
    }
}





