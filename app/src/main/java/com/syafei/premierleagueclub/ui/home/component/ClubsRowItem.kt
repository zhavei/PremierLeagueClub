package com.syafei.premierleagueclub.ui.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syafei.premierleagueclub.data.model.ClubsModel
import com.syafei.premierleagueclub.ui.theme.PremierLeagueClubTheme

@Composable
fun ClubsRowItems(
    clubName: String,
    ground: String,
    logoUrl: String,
    backgroundLogoUrl: String,
    onClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Card(
        border = BorderStroke(5.dp, MaterialTheme.colors.background.copy(alpha = 0.2f)),
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = modifier.clickable { onClicked(clubName) }
        ) {
            AsyncImage(
                model = backgroundLogoUrl,
                contentDescription = "background logo",
                contentScale = ContentScale.Crop,
                alignment = Center,
                modifier = Modifier
                    .size(250.dp)
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .background(Color.Black.copy(alpha = 0.50f))
                    .padding(9.dp)
            ) {
                Text(
                    modifier = Modifier.align(CenterHorizontally),
                    text = clubName,
                    style = MaterialTheme.typography.body1.copy(
                        color = Color.White
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,

                    )
                Text(
                    modifier = Modifier.align(CenterHorizontally),
                    text = ground,
                    style = MaterialTheme.typography.subtitle2.copy(
                        color = Color.White
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            Box(
                modifier = Modifier
                    .padding(bottom = 55.dp)
                    .size(70.dp)
                    .align(Alignment.BottomCenter)
                    .background(Color.White, shape = CircleShape),
                contentAlignment = Center
            ) {

                AsyncImage(
                    model = logoUrl,
                    contentDescription = "logo",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(50.dp)
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RowItems() {

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

          ClubsRowItems(clubName = previewItem.clubName,
              ground = previewItem.ground,
              logoUrl = previewItem.logoUrl,
              backgroundLogoUrl = previewItem.backgroundLogoUrl, onClicked = {})
      }
}
