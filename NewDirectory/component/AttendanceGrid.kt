package com.example.figma_replicate.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight

@Composable

fun Attendance() {

    val checkIns = listOf("item1", "item2", "item3", "item4")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                8.dp
            )
        ){
            Text(text = "Today's Attendance", fontWeight = FontWeight.SemiBold)
        }

        LazyVerticalGrid (
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)



        ) {
            items(checkIns) { check ->
                Box(modifier =

                    Modifier
                        .padding(15.dp)
                        .size(100.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .shadow(
                            elevation = 1.dp,
                            clip = false
                        )
                        .background(Color.White))




                {

                    Text(text=check)
                }


            }



        }
    }
}

