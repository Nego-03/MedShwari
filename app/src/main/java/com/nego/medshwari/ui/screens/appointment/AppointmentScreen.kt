package com.nego.medshwari.ui.screens.appointment

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AppointmentScreen(navController: NavController){

    var selectedTab by remember { mutableStateOf("Appointments") }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color(0xFF0A9CF5),
                contentColor = Color.White
            ) {
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Dashboard") },
                    label = { Text("Dashboard") },
                    selected = selectedTab == "Dashboard",
                    onClick = { selectedTab = "Dashboard" }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Event, contentDescription = "Appointments") },
                    label = { Text("Appointments") },
                    selected = selectedTab == "Appointments",
                    onClick = { selectedTab = "Appointments" }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = selectedTab == "Profile",
                    onClick = { selectedTab = "Profile" }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = "Your Appointments",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(5) { index ->
                    AppointmentCard(
                        doctorName = "Dr. Jane Smith",
                        date = "May ${10 + index}, 2025",
                        time = "10:00 AM",
                        hospital = "MedShwari Hospital"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun AppointmentCard(
    doctorName: String,
    date: String,
    time: String,
    hospital: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Doctor: $doctorName", fontWeight = FontWeight.SemiBold)
            Text("Date: $date")
            Text("Time: $time")
            Text("Location: $hospital")
        }
    }
}



@Preview(showBackground = true)
@Composable
fun AppointmentScreenPreview(){

    AppointmentScreen(rememberNavController())
}