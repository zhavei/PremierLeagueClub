package com.syafei.premierleagueclub.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.syafei.premierleagueclub.R
import com.syafei.premierleagueclub.ui.about.AboutScreen
import com.syafei.premierleagueclub.ui.home.HomeScreen
import com.syafei.premierleagueclub.ui.maincomponent.MainBottomBar
import com.syafei.premierleagueclub.ui.route.ScreenRoute

@Composable
fun PremierLeagueClubApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.DarkGray)

    Scaffold(
        topBar = {

            TopAppBar(
                modifier = modifier,
                backgroundColor = Color.DarkGray,
                title = {
                    Text(
                        text = stringResource(id = ScreenRoute.titleFromRoute(currentRoute ?: "")),
                        color = Color.White,
                        modifier = modifier.padding(6.dp)
                    )
                },
                navigationIcon = if (currentRoute != ScreenRoute.Home.route) ({
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                }) else null,

                actions = {
                    if (currentRoute == ScreenRoute.Home.route) {
                        IconButton(onClick = {
                            navController.navigate(ScreenRoute.About.route)
                        }) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                tint = Color.White,
                                contentDescription = stringResource(
                                    R.string.about
                                )
                            )
                        }
                    }
                }
            )

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
                    //navController.navigate(ScreenRoute.DetailClub.createRoute(it))
                    //trakir masih di sini, bootom navigation g ilang pas masuk screeen ini
                })
            }

            composable(ScreenRoute.About.route) {
                AboutScreen()
            }
        }

    }

}