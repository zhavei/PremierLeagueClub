package com.syafei.premierleagueclub.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        title = {
            Text(
                text = "Premier League Clubs",
                color = Color.White,
                modifier = modifier.padding(6.dp)
            )
        }
    )
}