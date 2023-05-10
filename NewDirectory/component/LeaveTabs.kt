package com.example.figma_replicate.ui.component

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color


@Composable
fun LeaveTabs(tabs: List<String>, selectedIndex: Int, onTabSelected: (Int) -> Unit) {
    TabRow(selectedTabIndex = selectedIndex, contentColor = Color(0xFFFF6B00)) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = { Text(title) },
                selected = selectedIndex == index,
                onClick = { onTabSelected(index) }
            )

        }
    }
}
