package com.syafei.premierleagueclub.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.syafei.premierleagueclub.ui.home.HomeScreen
import com.syafei.premierleagueclub.ui.maincomponent.MainBottomBar
import com.syafei.premierleagueclub.ui.maincomponent.MainTopBar
import com.syafei.premierleagueclub.ui.route.ScreenRoute

@Composable
fun PremierLeagueClubApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.Transparent)

    Scaffold(
        topBar = {
            MainTopBar()
        },
        modifier = modifier,
        bottomBar = {
            if (currentRoute != ScreenRoute.DetailClub.route) {
                MainBottomBar(navController = navController)
            }
        },
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = ScreenRoute.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ScreenRoute.Home.route) {
                HomeScreen(onClicked = {
                    navController.navigate(ScreenRoute.DetailClub.createRoute(it))
                    TODO("trakir masih di sini")
                })
            }
        }

    }

}