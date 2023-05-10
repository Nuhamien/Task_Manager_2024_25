package com.example.figma_replicate.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figma_replicate.R

@Composable
fun PasswordComponent(
    onFinish: (String) -> Unit,
    focusedBorderColor: Color = Color(0xFFFF7F50),
    unfocusedBorderColor: Color = Color(0xFFD9D9D9),
    errorBorderColor: Color = Color.Red
) {
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    val isFilled = password.isNotBlank() && confirmPassword.isNotBlank()
    val isMatch = password == confirmPassword
    val canFinish = isFilled && isMatch

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val buttonHeight = 46.dp
        val buttonWidth =  288.dp
        val montserratMedium= FontFamily(Font(resId = R.font.montserrat_medium))
        val secondaryColor = Color(0xFF36454F)
        val gray = Color(0xFFD9D9D9)
        val unfocused = Color(0xFFD3D1D1)

        Text(
            text = "Password",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                showError = false
            },
            modifier = Modifier
                .width(buttonWidth)
                .height(buttonHeight),
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            isError = showError && !isMatch,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = focusedBorderColor,
                unfocusedBorderColor = unfocusedBorderColor,
                errorBorderColor = errorBorderColor,
                unfocusedContainerColor = gray
            )
        )
        if (showError && !isMatch) {
            Text(
                text = "Password mismatch",
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.Start)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Confirm Password",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.Start)
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
                showError = false
            },
            modifier = Modifier
                .width(buttonWidth)
                .height(buttonHeight),
//                .background(Color(0xFFD3D3D3)),
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            isError = showError && !isMatch,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = focusedBorderColor,
                unfocusedBorderColor = unfocusedBorderColor,
                errorBorderColor = errorBorderColor,
                unfocusedContainerColor = gray
            )
        )
        if (showError && !isMatch) {
            Text(
                text = "Password mismatch",
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.align(Alignment.Start)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        FinishButtonComponent(
            enabled = canFinish,
            showError = showError && !isMatch,
            onClick = {
                if (!canFinish) {
                    showError = true
                } else {
                    onFinish(password)
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PasswordComponentPreview(){
    PasswordComponent(onFinish= {})
}

