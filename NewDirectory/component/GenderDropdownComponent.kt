package com.example.figma_replicate.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GenderDropdownComponent(
    selectedGender: String?,
    onGenderSelected: (String) -> Unit,
    showError: Boolean,
    modifier: Modifier = Modifier
) {
    val options = listOf("Male", "Female", "Prefer not to say")
    var expanded by remember { mutableStateOf(false) }

    val dropdownWidth = 289.dp
    val dropdownHeight = 168.dp
    val cornerRadius = 20.dp
    val shadowColor = Color(0x1A000000) // 10% opacity black
    val radioSelected = Color(0xFF36454F)
    val radioUnselected = Color(0xFFD9D9D9)
    val buttonColor = Color(0xFFD3D3D3)

    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .width(dropdownWidth)
        ) {
            // Dropdown trigger
            Box(
                modifier = Modifier
                    .width(dropdownWidth)
                    .height(46.dp)
                    .background(color = buttonColor, RoundedCornerShape(cornerRadius))
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(cornerRadius),
                        ambientColor = shadowColor,
                        spotColor = shadowColor,
                        clip = false
                    )

                    .border(1.dp, Color(0xFFD9D9D9), RoundedCornerShape(cornerRadius))
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = selectedGender ?: "Select your gender",
                        color = if (selectedGender == null) Color(0xFFBDBDBD) else radioSelected,
                        fontSize = 16.sp,
                        fontWeight = if (selectedGender == null) FontWeight.Normal else FontWeight.Medium,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(
                        imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                        contentDescription = if (expanded) "Collapse" else "Expand",
                        modifier = Modifier.size(40.dp).clickable { expanded = true },
                        tint = Color(0xFF36454F) // 50% opacity
                    )
                }
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(dropdownWidth)
                    .height(dropdownHeight)
                    .background(Color.White, RoundedCornerShape(cornerRadius))
                    .shadow(
                        elevation = 4.dp,
                        shape = RoundedCornerShape(cornerRadius),
                        ambientColor = shadowColor,
                        spotColor = shadowColor,
                        clip = false
                    ),
                offset = DpOffset(x = 0.dp, y = 200.dp)
            ) {
                options.forEach { gender ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onGenderSelected(gender)
                                expanded = false
                            }
                            .padding(horizontal = 16.dp, vertical = 12.dp)
                    ) {
                        // Custom radio button
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .border(1.dp, radioUnselected, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(10.dp)
                                    .background(
                                        color = if (selectedGender == gender) radioSelected else radioUnselected,
                                        shape = CircleShape
                                    )
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = gender,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = radioSelected
                        )
                    }
                }
            }
        }
        if (showError) {
            Text(
                text = "Please select your gender",
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
        }
    }
}

