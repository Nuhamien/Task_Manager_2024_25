package com.example.figma_replicate.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CreateAccountTextComponent(){
    Row(){
        Text(
            text = "Create account",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF36454F)
        )
    }
}