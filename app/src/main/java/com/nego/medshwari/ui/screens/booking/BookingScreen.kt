package com.nego.medshwari.ui.screens.booking

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nego.medshwari.R
import com.nego.medshwari.ui.theme.newBlue
import com.nego.medshwari.ui.theme.newSkyBlue


@Composable
fun BookingScreen(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = newSkyBlue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Your Bookings",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = newBlue

        )
        Spacer(modifier = Modifier.height(20.dp))

        // Placeholder image for booking
        Image(
            painter = painterResource(id = R.drawable.book),
            contentDescription = "Bookings",
            modifier = Modifier
                .size(180.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "You haven't booked any appointment yet.",
            fontSize = 16.sp,
            color = newBlue


        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(onClick = { /*TODO: Navigate to booking*/ }) {
            Text("Book Now")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun BookingScreenPreview(){

    BookingScreen(rememberNavController())
}