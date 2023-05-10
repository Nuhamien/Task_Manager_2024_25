package com.example.figma_replicate.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figma_replicate.R

@Composable
fun NameTextField(
    value: String,
    onValueChange: (String) -> Unit,
    isError: Boolean,
    placeholder: String = "John doe",
    modifier: Modifier = Modifier,
    onDone: (() -> Unit)? = null,
    focusedBorderColor: Color = Color(0xFFFF7F50),
    unfocusedBorderColor: Color = Color(0xFFD9D9D9),
    errorBorderColor: Color = Color.Red
) {
    val montserratMedium= FontFamily(Font(resId = R.font.montserrat_medium))
    val secondaryColor = Color(0xFF36454F)
    val gray = Color(0xFFD9D9D9)
    val unfocused = Color(0xFFD3D1D1)

    Column() {
        Text(
            text = "Your Full Name",
            fontSize = 14.sp,
            fontFamily = montserratMedium,
            color =secondaryColor,
            modifier = Modifier.align(Alignment.Start)

            )
        Spacer(modifier = Modifier.height(2.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text("John doe", color = unfocused, fontSize = 14.sp) },
            singleLine = true,
            minLines = 1,
            maxLines = 1,
            isError = isError,
            modifier = Modifier.height(46.dp).width(288.dp)
            ,
            shape = RoundedCornerShape(20.dp),
            textStyle = TextStyle(fontSize = 14.sp),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text
            ),
            keyboardActions = KeyboardActions(
                onDone = { onDone?.invoke() }
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = focusedBorderColor,
                unfocusedBorderColor = unfocusedBorderColor,
                errorBorderColor = errorBorderColor,
                unfocusedContainerColor = gray
            )

        )
    }


}