package com.example.figma_replicate.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.figma_replicate.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun EditProfileContent(innerPadding: PaddingValues){
    var fullName: String by remember {mutableStateOf("John Doe")}
    var designation: String by remember {mutableStateOf("Lead UI/UX Developer")}
    var email: String by remember {mutableStateOf("JohnDoe@staffsync.com")}
    var EmployeeType:String by remember {mutableStateOf("Permanent")}

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "profile picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Box(){
            Text("John Doe", fontWeight = FontWeight.SemiBold)
        }
        Box(){
            Text("Lead UI/UX Developer", fontWeight = FontWeight.SemiBold)
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            OutlinedTextField(
                value=fullName,
                shape = RoundedCornerShape(12.dp),
                onValueChange = { fullName = it },
                label= { Text("Full Name") }


            )
            OutlinedTextField(
                value=email,
                shape = RoundedCornerShape(8.dp),
                onValueChange = {email = it},
                label= { Text("Email Address") }

            )
            OutlinedTextField(
                value=designation,
                onValueChange= { designation = it},
                shape = RoundedCornerShape(8.dp),
                label= { Text("Designation") }

            )
            OutlinedTextField(
                value=EmployeeType,
                shape = RoundedCornerShape(8.dp),
                onValueChange= { EmployeeType = it},
                label= { Text("Employee Type") }

            )
        }
        Button(
                onClick = { },
                 colors = ButtonDefaults.buttonColors(
            containerColor = Color(red = 255, green = 127, blue = 80)
        ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 8.dp)


        ) {
        Text(text = "Submit", fontWeight = FontWeight.Bold)
    }


    }

}
