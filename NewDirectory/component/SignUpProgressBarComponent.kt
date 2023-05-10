package com.example.figma_replicate.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figma_replicate.R

@Composable
fun SignUpProgressBarComponent(
    steps: List<String>,
    currentStep: Int,
    onStepClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val orange = Color(0xFFFF7F50)
    val gray = Color(0xFFD9D9D9)
    val lightGray = Color(0xFFD3D3D3)
    val montserratMedium = FontFamily(Font(resId = R.font.montserrat_medium))

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        steps.forEachIndexed { index, label ->
            val isCompleted = index < currentStep
            val isCurrent = index == currentStep
            val circleColor = when {
                isCompleted -> orange
                isCurrent -> Color.White
                else -> lightGray
            }
            val borderColor = when {
                isCompleted -> orange
                isCurrent -> orange
                else -> lightGray
            }
            val labelColor = when {
                isCompleted -> orange
                else -> lightGray
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = label,
                    color = labelColor,
                    fontWeight = FontWeight.Medium,
                    fontSize = 5.sp,
                    fontFamily = montserratMedium,
//                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(circleColor)
                        .border(2.dp, borderColor, CircleShape)
                        .clickable(
                            enabled = isCompleted,
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) {
                            if (isCompleted) onStepClick(index)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    if (isCompleted) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Completed",
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    } else {
                        Text(
                            text = ""
//
                        )
                    }
                }
            }
            if (index < steps.lastIndex) {
                Spacer(
                    modifier = Modifier
                        .width(28.dp)// 31px between circles
                        .height(2.dp)
                        .background(if (index < currentStep) orange else lightGray)
//                        .align(Alignment.CenterVertically)
                )
            }

        }
    }
}

// Usage Example (in FullNameScreen.kt):
// SignUpProgressBarComponent(
//     steps = listOf("Email", "Name", "Birthday", "Gender", "Pass"),
//     currentStep = 1,
//     onStepClick = { /* handle step click */ }
// )
