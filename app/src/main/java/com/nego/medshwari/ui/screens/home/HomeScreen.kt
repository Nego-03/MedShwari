package com.nego.medshwari.ui.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.nego.medshwari.ui.theme.newBlue
import com.nego.medshwari.ui.theme.newLightBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){

    Scaffold(


        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = newBlue
            ){

            }
        },


        //FloatingActionButton
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add action */ },
                containerColor = newBlue
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },

        //Content
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
            ) {


                //Main Contents of the page
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {

                    Text(text = "Welcome!",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp
                    )

                    Icon(imageVector = Icons.Default.AccountCircle,contentDescription = "Profile",
                        modifier = Modifier.size(40.dp)
                    )


                }
                Spacer(modifier = Modifier.height(40.dp))

                //Searchbar
                var search by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = "",
                    onValueChange = { search = it },
                    modifier = Modifier.fillMaxWidth().padding(start = 5.dp, end = 5.dp), shape = RoundedCornerShape(12.dp),
                    leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
                    placeholder = { Text(text = "Search for Service") }
                )

                Spacer(modifier = Modifier.height(20.dp))

                //Card

                Card(
                    colors = CardDefaults.cardColors(containerColor = newLightBlue),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    shape = RoundedCornerShape(16.dp),

                    ) {
                    Column(
                        modifier = Modifier.padding(start = 70.dp, top = 50.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(text = "Stay Healthy!", fontWeight = FontWeight.Bold, fontSize = 18.sp)

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(text = "Regular Check-ups can save lives.", fontWeight = FontWeight.Bold, fontSize = 18.sp)

                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                //Services
                Text(text = "What do you need?", fontWeight = FontWeight.Bold, fontSize = 30.sp)

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    colors = CardDefaults.cardColors(containerColor = newLightBlue),
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    shape = RoundedCornerShape(12.dp),
                    elevation = CardDefaults.cardElevation(4.dp)

                    ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {


                    }
                }

















            }
        }
    )

    //End of scaffold

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){

    HomeScreen(rememberNavController())
}