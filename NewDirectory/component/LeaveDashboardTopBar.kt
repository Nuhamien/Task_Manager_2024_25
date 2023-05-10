package com.example.figma_replicate.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaveDashboardTopBar(navController: NavController) {
    TopAppBar(
        title = { Text("All leaves") },
        actions = {
            IconButton(onClick = { navController.navigate("notification") }) {
                Icon(

                    imageVector = Icons.Filled.Notifications,
                    modifier = Modifier.size(20.dp),
                    contentDescription = "Notifications",
                    tint = Color.Black
                )
            }

        }
    )

}

