package com.example.figma_replicate.ui.component

import android.app.DatePickerDialog
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.Calendar

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DateOfBirthField(
    modifier: Modifier = Modifier,
    onDateChanged: (String) -> Unit
) {
    val labelColor = Color(0xFF36454F)
    val fieldBg = Color(0xFFD9D9D9)
    val errorColor = Color(0xFFD32F2F)
    val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val context = LocalContext.current

    var text by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    fun validateDate(input: String): Boolean {
        return try {
            val date = LocalDate.parse(input, dateFormatter)
            val today = LocalDate.now()
            val age = Period.between(date, today).years
            age >= 18 && !date.isAfter(today)
        } catch (e: DateTimeParseException) {
            false
        }
    }

    fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(
            context,
            { _, y, m, d ->
                val picked = String.format("%02d/%02d/%04d", d, m + 1, y)
                text = picked
                if (validateDate(picked)) {
                    showError = false
                    errorMessage = ""
                    onDateChanged(picked)
                } else {
                    showError = true
                    errorMessage = "Enter valid birth date"
                }
            },
            year, month, day
        ).show()
    }

    Column(modifier = modifier) {
        Text(
            text = "date of birth",
            color = labelColor,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        TextField(
            value = text,
            onValueChange = {
                text = it
                if (it.isEmpty()) {
                    showError = false
                    errorMessage = ""
                } else if (validateDate(it)) {
                    showError = false
                    errorMessage = ""
                    onDateChanged(it)
                } else {
                    showError = true
                    errorMessage = "Enter valid birth date"
                }
            },
            placeholder = { Text("DD/MM/YYYY", color = labelColor.copy(alpha = 0.5f)) },
            trailingIcon = {
                IconButton(onClick = { showDatePicker() }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Pick date",
                        tint = labelColor
                    )
                }
            },
            isError = showError,
            singleLine = true,
            shape = RoundedCornerShape(24.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = fieldBg,
                focusedContainerColor = fieldBg,
                disabledContainerColor = fieldBg,
                errorContainerColor = fieldBg,
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(fieldBg, RoundedCornerShape(24.dp))
        )
        if (showError) {
            Text(
                text = errorMessage,
                color = errorColor,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 8.dp, top = 2.dp)
            )
        }
    }
}

