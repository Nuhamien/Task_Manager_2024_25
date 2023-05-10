package com.example.figma_replicate.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figma_replicate.R


@Composable
fun ChangePasswordContent(paddingValues: PaddingValues) {
    var oldPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var oldPasswordVisible by remember { mutableStateOf(false) }
    var newPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Set a new password",
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Old Password
        OutlinedTextField(
            value = oldPassword,
            onValueChange = { oldPassword = it },
            label = { Text("Old Password") },
            visualTransformation = if (oldPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { oldPasswordVisible = !oldPasswordVisible }) {
                    Icon(
                        painter = if (oldPasswordVisible) painterResource(R.drawable.ic_visibility) else painterResource(R.drawable.ic_visibility_off),
                        contentDescription = "Toggle password visibility"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            shape = RoundedCornerShape(12.dp)
        )

        // New Password
        OutlinedTextField(
            value = newPassword,
            onValueChange = { newPassword = it },
            label = { Text("New Password") },
            visualTransformation = if (newPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { newPasswordVisible = !newPasswordVisible }) {
                    Icon(
                        painter = if (newPasswordVisible) painterResource(R.drawable.ic_visibility) else painterResource(R.drawable.ic_visibility_off),
                        contentDescription = "Toggle password visibility"
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            shape = RoundedCornerShape(12.dp)
        )

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6D3F))
        ) {
            Text("Change Password", color = Color.White)
        }
    }
}
