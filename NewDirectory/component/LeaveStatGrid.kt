package com.example.figma_replicate.ui.component


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable

fun LeaveStatGrid() {

        Row(modifier = Modifier.fillMaxWidth()) {
            StatCard(
                backgroundColor = Color.hsl(216f, 1f, 0.98f),
                title = "Present Employees",
                border = Color.hsl(215f, 0.99f, 0.59f),
                value = "20",
                modifier = Modifier.weight(1f)
            )

            StatCard(

                backgroundColor = Color.hsl(0f, 0f, 0.95f),
                title = "Absent Employees",
                value = "2",
                border = Color.hsl(5f, 1f, 0.73f),
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth()){
            StatCard(

            backgroundColor = Color.hsl(83f, 0.67f, 0.98f),
            title = "Leave Pending",
            value = "2",
            border= Color.hsl(78f, 0.62f, 0.52f),
            modifier = Modifier.weight(1f)
        )}

    }



@Composable
fun StatCard(
    backgroundColor: Color,
    title: String,
    value: String,
    border: Color = Color.Black,
    valueColor: Color = border,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(4.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        border = BorderStroke(1.dp, border)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                value,
                color = border,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}
