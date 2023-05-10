package com.example.figma_replicate.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContinueButtonComponent(
    enabled: Boolean,
    showError: Boolean,
    onClick: () -> Unit,
    step: Int,
    modifier: Modifier = Modifier
) {
    val orange = Color(0xFFFF7F50)
    val gray = Color(0xFFD9D9D9)

    // Decide error message based on step
    val errorMessage = when (step) {
        1 -> "Enter a valid name"
        2 -> "Enter valid birth date"
        3 -> "Enter valid gender"
        else -> "Enter valid value"
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = onClick,
            enabled = enabled,
            modifier = modifier
                .width(288.dp)
                .height(46.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = orange,
                disabledContainerColor = gray
            )
        ) {
            Text(
                text = "Continue",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        if (showError) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}