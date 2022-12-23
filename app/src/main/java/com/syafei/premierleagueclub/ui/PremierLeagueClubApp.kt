package com.syafei.premierleagueclub.ui

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.syafei.premierleagueclub.R
import com.syafei.premierleagueclub.ui.about.AboutScreen
import com.syafei.premierleagueclub.ui.details.ItemDetailScreen
import com.syafei.premierleagueclub.ui.favorite.FavoriteScreen
import com.syafei.premierleagueclub.ui.home.HomeScreen
import com.syafei.premierleagueclub.ui.home.component.SplashScreenScreen
import com.syafei.premierleagueclub.ui.maincomponent.MainBottomBar
import com.syafei.premierleagueclub.ui.route.ScreenRoute

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun PremierLeagueClubApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val firstBackStackRoute = navController.backQueue.firstOrNull()?.destination?.route
    firstBackStackRoute?.let {
        navController.popBackStack(firstBackStackRoute, true)
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.DarkGray)

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = modifier, backgroundColor = Color.DarkGray, title = {
                    Text(
                        text = stringResource(id = ScreenRoute.titleFromRoute(currentRoute ?: "")),
                        color = Color.White,
                        modifier = modifier.padding(6.dp)
                    )
                },
                navigationIcon = if (
                    currentRoute != ScreenRoute.Home.route &&
                    currentRoute != ScreenRoute.Favorite.route &&
                    currentRoute != ScreenRoute.SplashScreen.route
                ) ({
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(R.string.back),
                            tint = Color.White
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
            if (
                currentRoute != ScreenRoute.DetailClub.route &&
                currentRoute != ScreenRoute.About.route &&
                currentRoute != ScreenRoute.SplashScreen.route
            ) {
                MainBottomBar(navController = navController)
            }
        },
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = ScreenRoute.SplashScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(ScreenRoute.SplashScreen.route) {
                SplashScreenScreen(navController = navController)
            }

            composable(ScreenRoute.Home.route) {
                HomeScreen(onClicked = {
                    navController.navigate(ScreenRoute.DetailClub.createRoute(it))
                })

            }

            composable(ScreenRoute.Favorite.route) {
                FavoriteScreen(onCLick = {
                    navController.navigate(ScreenRoute.DetailClub.createRoute(it))
                })
            }

            composable(ScreenRoute.About.route) {
                AboutScreen()
            }

            //details route
            composable(
                route = ScreenRoute.DetailClub.route,
                arguments = listOf(navArgument("clubName") { type = NavType.StringType }),
            ) {
                val name = it.arguments?.getString("clubName") ?: ""
                ItemDetailScreen(
                    name = name
                )
            }
        }
    }
}