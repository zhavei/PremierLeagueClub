package com.syafei.premierleagueclub.ui.maincomponent

import androidx.compose.ui.graphics.vector.ImageVector
import com.syafei.premierleagueclub.ui.route.ScreenRoute

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screenRoute: ScreenRoute
)
