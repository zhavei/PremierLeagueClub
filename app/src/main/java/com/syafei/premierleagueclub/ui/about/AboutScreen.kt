package com.syafei.premierleagueclub.ui.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syafei.premierleagueclub.R
import com.syafei.premierleagueclub.ui.theme.PremierLeagueClubTheme


@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
            .horizontalScroll(scrollState)
    ) {
        Image(
            painter = painterResource(id = R.drawable.syafei),
            contentDescription = stringResource(R.string.about_photo_content),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape),
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.about_developer),
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )
        Text(
            text = stringResource(R.string.about_developer_email),
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(16.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun PrevAboutScreen() {
    PremierLeagueClubTheme() {
        AboutScreen()
    }
}