import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figma_replicate.R

@Composable
fun ListOfActivity() {
    val list = listOf("Item1", "Item1", "Item1")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()) // Enable scrolling
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Your Activity",
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        list.forEach { activity ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_checkin_),
                    contentDescription = "check In"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text("Check In", fontWeight = FontWeight.Bold)
                    Text("Apr 16 2025", fontWeight = FontWeight.Light, fontSize = 10.sp)
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "10:00AM",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(red = 255, green = 127, blue = 80)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = "Check in", fontWeight = FontWeight.Bold)
        }
    }
}
