package com.syafei.premierleagueclub.ui.maincomponent

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.syafei.premierleagueclub.ui.route.ScreenRoute

@Composable
fun MainBottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val navigationItem = listOf(
        NavigationItem(
            title = "Home",
            icon = Icons.Default.Home,
            screenRoute = ScreenRoute.Home
        ),
        NavigationItem(
            title = "Favorite",
            icon = Icons.Default.Favorite,
            screenRoute = ScreenRoute.Home
        )
    )

    BottomNavigation(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.primary
    ) {
        navigationItem.map { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title,
                        tint = Color.DarkGray
                    )
                },
                label =
                {
                    Text(
                        item.title,
                        color = Color.DarkGray
                    )
                },
                selected =
                currentRoute == item.screenRoute.route,
                unselectedContentColor = Color.White,
                onClick = {
                    navController.navigate(item.screenRoute.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
            )
        }
    }
}