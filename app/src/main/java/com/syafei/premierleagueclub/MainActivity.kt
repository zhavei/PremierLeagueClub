package com.syafei.premierleagueclub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.syafei.premierleagueclub.ui.PremierLeagueClubApp
import com.syafei.premierleagueclub.ui.theme.PremierLeagueClubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PremierLeagueClubTheme {
                // A surface container using the 'background' color from the theme
                    PremierLeagueClubApp()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PremierLeagueClubTheme {
        PremierLeagueClubApp()
    }
}