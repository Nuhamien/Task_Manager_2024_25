package com.example.figma_replicate.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import com.example.figma_replicate.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun NotificationSettingContent(innerPadding: PaddingValues) {
    var isChecked by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .padding(innerPadding)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // Aligns content left and right
        ) {
            Column {
                Text(text = "Notifications", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.bodyLarge, color=MaterialTheme.colorScheme.primary)
                Text(text = "Turn notification on or off", style = MaterialTheme.typography.bodySmall)
            }

            Switch(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    uncheckedThumbColor = Color.White,
                    checkedTrackColor = MaterialTheme.colorScheme.primary,
                    uncheckedTrackColor = Color.Black

                ),

                modifier = Modifier.scale(0.75f)
            )
        }

        val options = listOf(
            "Only my activities" to "Only be notified of your activity with managers.",
            "Only others activities" to "Only be notified of others activities with managers.",
            "All activities" to "Be notified of all the activities."
        )

        var expanded by remember { mutableStateOf(false) }
        var selectedIndex by remember { mutableStateOf(0) }

        Column(modifier = Modifier.padding(8.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()


            ){
                Column(
                    modifier = Modifier.clickable {
                        expanded = !expanded
                    }



                ){
                    Text(
                        text = "Get notified from",
                        color = Color(0xFFFF5722),
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Choose the activities you like to be notified about",
                        style = MaterialTheme.typography.bodySmall,

                    )
                }
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )

            }

            if (expanded) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(top = 8.dp)
                ) {
                    options.forEachIndexed { index, pair ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    selectedIndex = index
                                    expanded = false
                                }
                                .padding(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = pair.first,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFFFF5722)
                                )
                                Text(
                                    text = pair.second,
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }

                            RadioButton(
                                selected = index == selectedIndex,
                                onClick = {
                                    selectedIndex = index
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }



        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Clear Notification",
                    color = Color(0xFFFF5722),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Clear notifications from your log",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_broom),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }



    }


}
