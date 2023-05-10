package com.example.figma_replicate.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.figma_replicate.R
@Composable
fun ListCardTeamLeave() {
    LeaveTeamLeave("John Doe", "Lead UI/UX Developer",
        "Apr 15, 2025",
        "Apr 18 2025",
        "3")
    Spacer(modifier = Modifier.height(8.dp))
    LeaveTeamLeave("John Doe", "Lead UI/UX Developer",
        "Apr 15, 2025",
        "Apr 18 2025",
        "3")
    Spacer(modifier = Modifier.height(8.dp))
    LeaveTeamLeave("John Doe", "Lead UI/UX Developer",
        "Apr 15, 2025",
        "Apr 18 2025",
        "3")
}
@Composable
fun LeaveTeamLeave(
    name: String,
    designation: String,
    startDate: String,
    endDate: String,
    applyDays: String,
    chronology: Chronology = Chronology.TEAMLEAVE
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Image(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile picture"
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally // Center name and designation
                ) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = designation,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                }
            }

            Divider(thickness = 1.dp, color = Color(0xFFE0E0E0))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "$startDate - $endDate",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Apply Days\n$applyDays",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .defaultMinSize(minWidth = 100.dp),

                    shape = MaterialTheme.shapes.small,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF05CC8C)) // Custom color for approve button
                ) {
                    Text("Approve")
                }

                Spacer(modifier = Modifier.width(12.dp))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .defaultMinSize(minWidth = 100.dp),
                    shape = MaterialTheme.shapes.small
                ) {
                    Text("Reject", fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }


}
