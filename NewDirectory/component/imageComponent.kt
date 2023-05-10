package com.example.figma_replicate.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.figma_replicate.R

@Composable
fun ImageComponent(){
Row(){
    Image(
        painter = painterResource(id = R.drawable.signup_illustration),
        contentDescription = "Sign Up Illustration",
        modifier = Modifier
            .height(342.dp)
            .width(348.dp)
    )
}
}