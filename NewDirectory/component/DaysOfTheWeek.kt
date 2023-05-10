package com.example.figma_replicate.ui.component

import android.os.Build
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.items
import java.time.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import java.time.format.DateTimeFormatter


@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun DaysOfTheWeek() {
    val curr = LocalDate.now()
    val currDay = curr.dayOfMonth
    val currFormat = curr.format(DateTimeFormatter.ofPattern("dd"))
    val start = curr.with(DayOfWeek.MONDAY)
    val days = mutableListOf<String>()
    val month = mutableListOf<String>()
    for (i in 0..6) {
        val day = start.plusDays(i.toLong())
        days.add(day.format(DateTimeFormatter.ofPattern("dd")))
        month.add(day.format(DateTimeFormatter.ofPattern("MMM")))
    }
    val combinedList = days.zip(month)

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
        , horizontalArrangement = Arrangement.spacedBy(10.dp)


    ) {
        items(combinedList) { (day, month) ->
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(if (day == currFormat.toString()) Color(0xFFFF7F50) else Color.White)
                    .shadow(elevation = 0.5.dp)
                    .padding(horizontal = 20.dp, vertical = 8.dp)

            )
            {
                Text(
                    day,
                    fontWeight = FontWeight.Bold,
                    color = if (day == currFormat.toString()) Color.White else Color.Black

                )
                Text(
                    month,
                    color = if (day == currFormat.toString()) Color.White else Color.Black

                )


            }
        }


    }

}