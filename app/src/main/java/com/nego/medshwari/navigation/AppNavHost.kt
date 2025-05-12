package com.nego.medshwari.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nego.medshwari.repository.UserRepository
import com.nego.medshwari.ui.screens.about.AboutScreen
import com.nego.medshwari.ui.screens.appointment.AppointmentScreen
import com.nego.medshwari.ui.screens.booking.BookingScreen
import com.nego.medshwari.ui.screens.dashboard.DashboardScreen
import com.nego.medshwari.ui.screens.doctor.DoctorScreen
import com.nego.medshwari.ui.screens.home.HomeScreen
import com.nego.medshwari.ui.screens.splash.SplashScreen
import com.nego.medshwari.viewModel.AuthViewModel
import com.nego.zawadimart.ui.screens.auth.LoginScreen
import com.nego.zawadimart.ui.screens.auth.RegisterScreen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH
) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }

        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUT_APPOINTMENT) {
            AppointmentScreen(navController)
        }

        composable(ROUT_BOOKING) {
            BookingScreen(navController)
        }

        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }

        composable(ROUT_DOCTOR) {
            DoctorScreen(navController)
        }



        //AUTHENTICATION


            }
        }
