package com.example.figma_replicate.ui.component

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomTextComponent(onLogin: () -> Unit){
    val orange = Color(0xFFFF7F50)
    val gray = Color(0xFFD9D9D9)
    val darkGray = Color(0xFF36454F)
    val lightGray = Color(0xFFD3D3D3)
    val context = LocalContext.current

Column(
    horizontalAlignment = Alignment.CenterHorizontally
) {
    HorizontalDivider(
        color = gray,
        thickness = 1.dp,
        modifier = Modifier.width(288.dp)
    )
    Spacer(modifier = Modifier.height(8.dp))
    // Bottom Text
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Have an account? ",
            fontSize = 14.sp,
            color = darkGray
        )
        Text(
            text = "Log in",
            fontSize = 14.sp,
            color = orange,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable {
                Toast.makeText(context, "TODO: Navigate to Log in", Toast.LENGTH_SHORT).show()
                onLogin()
            }
        )

    }
} }
