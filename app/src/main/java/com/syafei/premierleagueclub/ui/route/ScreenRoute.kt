package com.syafei.premierleagueclub.ui.route

sealed class ScreenRoute(val route: String) {
    object Home : ScreenRoute("home")
    object Favorite : ScreenRoute("cart")
    object DetailClub : ScreenRoute("home/{clubName}") {
        fun createRoute(clubName: String) = "home/$clubName"
    }
}
