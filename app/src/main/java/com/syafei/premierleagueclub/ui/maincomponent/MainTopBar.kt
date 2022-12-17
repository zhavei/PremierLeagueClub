package com.syafei.premierleagueclub.ui.maincomponent

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.syafei.premierleagueclub.R
import com.syafei.premierleagueclub.ui.route.ScreenRoute

//ini belum kepake
@Composable
fun MainTopBar(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

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
}