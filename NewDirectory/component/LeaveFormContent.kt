package com.example.figma_replicate.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import android.app.DatePickerDialog
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.*
import androidx.compose.foundation.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import java.time.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*


@Composable
fun CalendarField(label: String, selectedDate: String, minDateMillis: Long? = null, onDateSelected: (String) -> Unit){
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = remember {
        DatePickerDialog(context, { _, y, m, d ->
            val formattedDate = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
                .format(GregorianCalendar(y, m, d).time)
            onDateSelected(formattedDate)
        }, year, month, day).apply {
            minDateMillis?.let { datePicker.minDate = it }
        }
    }

    Card(
        border = BorderStroke(1.dp, color=MaterialTheme.colorScheme.primary),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { datePickerDialog.show() },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = label, color = Color(0xFFFF6D00))
                Text(text = selectedDate, color = Color.Black)
            }
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Calendar",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LeaveFormContent(innerPadding: PaddingValues) {
    var title by remember { mutableStateOf("") }
    var leaveType by remember { mutableStateOf("") }
    var contactNumber by remember { mutableStateOf("") }
    var reason by remember { mutableStateOf("") }
    var startDate by remember {
        mutableStateOf(LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyyy")))
    }
    val sdf = SimpleDateFormat("MMM d, yyyy", Locale.getDefault())
    val minDateMillis = remember(startDate){
        sdf.parse(startDate)?.time ?: 0L
    }
    var endDate by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = leaveType,
                onValueChange = { leaveType = it },
                label = { Text("Leave Type") },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )

            CalendarField("Start Date", selectedDate = startDate) { startDate = it }
            CalendarField("End Date", selectedDate = endDate, minDateMillis=sdf.parse(startDate)?.time) { endDate = it }

            OutlinedTextField(
                value = reason,
                onValueChange = { reason = it },
                label = { Text("Reason") },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF7F50)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Text("Submit", fontWeight = FontWeight.Bold)
            }
        }
    }
}
