package com.example.figma_replicate.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.figma_replicate.ui.component.LeaveTeamLeave

@Composable
fun LeaveDashboardContent(innerPadding: PaddingValues) {
    val tabs = listOf("Upcoming", "Past", "Team Leave")
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        LeaveStatGrid()

        Spacer(modifier = Modifier.height(16.dp))

        LeaveTabs(tabs, selectedTabIndex) {
            selectedTabIndex = it
        }

        Spacer(modifier = Modifier.height(16.dp))

        when(selectedTabIndex) {
            0 -> ListCardUpcoming()
            1 -> ListCardPast()
            2 -> ListCardTeamLeave()

        }
    }
}
