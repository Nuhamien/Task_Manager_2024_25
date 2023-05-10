package com.example.figma_replicate.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
@Composable()
fun ScheduleGrid() {
    Row(modifier = Modifier.fillMaxWidth()) {
        StatCard(
            backgroundColor = Color.hsl(216f, 1f, 0.98f),
            title = "Leave Balance",
            border = Color.hsl(215f, 0.99f, 0.59f),
            value = "20",
            modifier = Modifier.weight(1f)
        )

        StatCard(

            backgroundColor = Color.hsl(83f, 0.67f, 0.98f),
            title = "Leave Approved",
            value = "2",
            border= Color.hsl(78f, 0.62f, 0.52f),
            modifier = Modifier.weight(1f)
        )
    }

    Spacer(modifier = Modifier.height(8.dp))

    Row(modifier = Modifier.fillMaxWidth()) {
        StatCard(
            backgroundColor = Color.hsl(171f, 0.54f, 0.98f),
            title = "Leave Pending",
            border = Color.hsl(177f, 0.6f, 0.47f),
            value = "20",
            modifier = Modifier.weight(1f)
        )


        StatCard(

            backgroundColor = Color.hsl(0f, 0f, 0.95f),
            title = "Leave Canceled",
            value = "2",
            border = Color.hsl(5f, 1f, 0.73f),
            modifier = Modifier.weight(1f)
        )
    }


}