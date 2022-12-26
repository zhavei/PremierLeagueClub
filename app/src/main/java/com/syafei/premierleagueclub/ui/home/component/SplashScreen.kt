package com.syafei.premierleagueclub.ui.home.component

import android.os.Build
import android.view.animation.OvershootInterpolator
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.syafei.premierleagueclub.R
import com.syafei.premierleagueclub.ui.route.ScreenRoute
import com.syafei.premierleagueclub.ui.theme.PremierLeagueClubTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreenScreen(navController: NavHostController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(Color.DarkGray)

    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(2000L)
        //remove backstack splashScreen
        navController.backQueue.first() { it.destination.route == "splash_screen" }
        navController.popBackStack()
        navController.navigate(route = ScreenRoute.Home.route)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.premier),
            "",
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .drawBehind {
                    drawCircle(
                        color = Color.White,
                        radius = 100.dp.toPx()
                    )
                }
        )
        Spacer(modifier = Modifier.size(25.dp))
        Text(
            text = stringResource(R.string.app_name),
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif
            )
        )

    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun SplashPrev() {

    val navController = rememberNavController()
    PremierLeagueClubTheme {
        SplashScreenScreen(navController = navController)
    }
}