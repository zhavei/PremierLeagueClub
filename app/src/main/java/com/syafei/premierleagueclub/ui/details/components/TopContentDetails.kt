package com.syafei.premierleagueclub.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syafei.premierleagueclub.data.model.ClubsModel
import com.syafei.premierleagueclub.ui.theme.PremierLeagueClubTheme

@Composable
fun TopContentDetails(
    logoUrl: String,
    name: String,
    nickName: String,
    founded: Int,
    ground: String,
    league: String,
    modifier: Modifier = Modifier
) {
    Box {
        /*Surface(color = Color.White,
            modifier = Modifier.fillMaxSize(),

            ) {

        }*/

        Surface(
            color = Color.LightGray,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(60.dp).copy(
                topStart = ZeroCornerSize,
                topEnd = ZeroCornerSize
            )
        ) {

            Box(
                modifier = Modifier
                    .size(70.dp)
                    .align(Alignment.Center)
                    .background(Color.White, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {

                AsyncImage(
                    model = logoUrl,
                    contentDescription = "logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(50.dp)
                )

            }

            /*AsyncImage(
                model = logoUrl,
                contentDescription = "logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(height = 16.dp, width = 16.dp)
                    .drawBehind {
                        drawCircle(color = Color.White, radius = 100f)
                    }
                    .clip(RoundedCornerShape(16.dp))
            )*/
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TopDetailPreview() {
    PremierLeagueClubTheme {

        val previewItem = ClubsModel(
            clubName = "man United",
            logoUrl = "https://toppng.com/uploads/preview/manchester-united-emblem-manchester-united-logo-dream-league-soccer-2018-11562942624odllvif9gl.png",
            nickName = "red Devils",
            founded = 2022,
            ground = "old traford",
            capacity = 12330,
            league = "premiere leauge",
            description = "String",
            backgroundLogoUrl = "https://t3.ftcdn.net/jpg/02/48/65/38/360_F_248653851_lMw1RUwPLpaBsSCT31eE3ZDY8WkIFpiq.jpg"
        )

        TopContentDetails(
            logoUrl = previewItem.logoUrl,
            name = previewItem.clubName,
            nickName = previewItem.nickName,
            founded = previewItem.founded,
            ground = previewItem.ground,
            league = previewItem.league
        )
    }
}
