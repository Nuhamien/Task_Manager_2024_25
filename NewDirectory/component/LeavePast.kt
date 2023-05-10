package com.example.figma_replicate.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
enum class Chronology {
    UPCOMING,
    PAST,
    TEAMLEAVE
}
@Composable
fun ListCardPast() {
    LeaveCardPast(
        dateRange = "Apr 15, 2025 - Apr 18, 2025",
        applyDays = "3 Days",
        leaveBalance = "16",
        approvedBy = "Martin Deo",
        status = "Rejected",
        statusColor = Color.Red,

    )
    Spacer(modifier = Modifier.height(8.dp))
    LeaveCardPast(
        dateRange = "Mar 10, 2025 - Mar 12, 2025",
        applyDays = "2 Days",
        leaveBalance = "19",
        approvedBy = "Martin Deo",
        status = "Approved",
        statusColor = Color(0xFF05CC8C),

    )
}

@Composable
fun LeaveCardPast(
    dateRange: String,
    applyDays: String,
    leaveBalance: String,
    approvedBy: String,
    status: String,
    statusColor : Color,
    chronology : Chronology = Chronology.PAST,
) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Date", color = Color.Black)
                Text(
                    status,
                    color = if (status.lowercase() == "approved") Color(0xFF05CC8C) else Color.Red,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                        .background(statusColor.copy(alpha = 0.1f), shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                )
            }
            Text(
                dateRange,
                fontWeight=FontWeight.Bold,
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onSurface
            )



            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Apply Days\n$applyDays", style = MaterialTheme.typography.bodyMedium ,color = MaterialTheme.colorScheme.onSurface)
                Text("Leave Balance\n$leaveBalance", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface)
                Text(
                    "Approved By\n$approvedBy",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )



            }
        }
    }
}

