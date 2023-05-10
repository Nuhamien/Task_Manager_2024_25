package com.example.figma_replicate.ui.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.figma_replicate.R
import com.example.figma_replicate.navigation.Routes
import com.example.figma_replicate.ui.theme.coral

@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun BottomNavBar(navController: NavHostController) {
    val items = listOf(
        Routes.HOME to "Home",
        Routes.SCHEDULE to "Schedule",
        Routes.OFFICE to "Office",
        Routes.HOLIDAY to "Holiday",
        Routes.PROFILE to "Profile"
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar {
        items.forEach { (route, label) ->
            NavigationBarItem(
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            modifier = Modifier
                                .width(24.dp)
                                .height(2.dp)
                                .background(if (currentRoute == route) coral else Color.Transparent)
//
                        )
                        Spacer(modifier = Modifier.height(8.dp)) // Space between line and icon
                        Icon(
                            painter = painterResource(
                                id = when (route) {
                                    Routes.HOME -> R.drawable.ic_home
                                    Routes.SCHEDULE -> R.drawable.ic_schedule
                                    Routes.OFFICE -> R.drawable.ic_office
                                    Routes.HOLIDAY -> R.drawable.ic_holiday
                                    Routes.PROFILE -> R.drawable.ic_profile
                                    else -> R.drawable.ic_home // Fallback icon
                                }
                            ),
                            contentDescription = label,
                            tint = if (currentRoute == route) coral else Color.Gray // Red when selected, gray otherwise
                        )
                    }
                },
                label = null,
                selected = currentRoute == route,
                onClick = {
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}