package com.example.figma_replicate.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.figma_replicate.R
import com.example.figma_replicate.navigation.Routes // Import Routes

@Composable

fun ProfileView(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "profile picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "John Doe",
                fontWeight = FontWeight.Bold,


            )
            Text(text = "Lead UI/UX developer")
        }
           Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notification:icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(20.dp)
                    .clickable {
                        navController.navigate(Routes.NOTIFICATION)
                    }
            )

    }
}