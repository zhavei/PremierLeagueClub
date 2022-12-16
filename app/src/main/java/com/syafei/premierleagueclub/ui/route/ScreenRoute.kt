package com.syafei.premierleagueclub.ui.route

import com.syafei.premierleagueclub.R

sealed class ScreenRoute(val route: String) {
    object Home : ScreenRoute("home")
    object Favorite : ScreenRoute("favorite")
    object About : ScreenRoute("about")
    object DetailClub : ScreenRoute("home/{clubName}") {
        fun createRoute(clubName: String) = "home/$clubName"
    }

    companion object {
        fun titleFromRoute(route: String): Int {
            return when (route) {
                Home.route -> R.string.app_name
                Favorite.route -> R.string.favorite
                DetailClub.route -> R.string.detail_club
                About.route -> R.string.about
                else -> R.string.app_name
            }
        }
    }

}
