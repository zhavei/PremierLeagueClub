package com.syafei.premierleagueclub.ui.details.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.syafei.premierleagueclub.R
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
    description: String,
    backGround: String,
    modifier: Modifier = Modifier
) {

    val scrollState = rememberScrollState()
    Box {
        Surface(
            color = Color.LightGray,
            modifier = Modifier
                .fillMaxSize(),
            shape = RoundedCornerShape(10.dp).copy(
                topStart = ZeroCornerSize,
                topEnd = ZeroCornerSize,
                bottomStart = ZeroCornerSize,
                bottomEnd = ZeroCornerSize
            )
        ) {
            Column {
                Row {

                    Text(
                        text = name,
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 310.dp, start = 12.dp, end = 5.dp)
                            .verticalScroll(rememberScrollState())
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Justify,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp)
                        .verticalScroll(rememberScrollState())
                )
            }
        }

        Surface(
            color = Color.White,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(60.dp).copy(
                topStart = ZeroCornerSize,
                topEnd = ZeroCornerSize
            )
        ) {

            Box {
                AsyncImage(
                    model = backGround,
                    contentDescription = "logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = modifier
                        .fillMaxWidth()
                        .horizontalScroll(scrollState)
                        .padding(top = 30.dp)
                ) {

                    AsyncImage(
                        model = logoUrl,
                        contentDescription = "logo",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(80.dp)
                            .drawBehind {
                                drawCircle(
                                    color = Color.White,
                                    radius = 150f
                                )
                            }
                    )

                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = name,
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        modifier = Modifier.padding(start = 12.dp)
                    )

                    Row {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_sports_soccer_24),
                            contentDescription = "icon",
                            modifier = Modifier
                                .size(25.dp)
                                .align(CenterVertically)
                                .padding(end = 5.dp)
                        )

                        Text(
                            text = nickName,
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                        Spacer(
                            modifier = Modifier
                                .width(10.dp)
                        )

                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_sports_soccer_24),
                            contentDescription = "icon",
                            modifier = Modifier
                                .size(25.dp)
                                .align(CenterVertically)
                                .padding(end = 5.dp)
                        )

                        Text(
                            text = founded.toString(),
                            style = MaterialTheme.typography.h6,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = ground,
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = league,
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center,
                        color = Color.White
                    )
                }
            }
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
            clubName = "Man United",
            logoUrl = "https://live.staticflickr.com/65535/52575728540_f13fb801a0_w.jpg",
            nickName = "Red Devils",
            founded = 2022,
            ground = "Old Traford",
            capacity = 12330,
            league = "Premiere Leauge",
            description = "A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend, so absorbed in the exquisite sense of mere tranquil existence, that I neglect my talents. I should be incapable of drawing a single stroke at the present moment; and yet I feel that I never was a greater artist than now. When, while the lovely valley teems with vapour around me, and the meridian sun strikes the upper surface of the impenetrable foliage of my trees, and but a few stray gleams steal into the inner sanctuary, I throw myself down among the tall grass by the trickling stream; and, as I lie close to the earth, a thousand unknown plants are noticed by me: when I hear the buzz of the little world among the stalks, and grow familiar with the countless indescribable forms of the insects and flies, then I feel the presence of the Almighty, who formed us in his own image, and the breath",
            backgroundLogoUrl = "https://t3.ftcdn.net/jpg/02/48/65/38/360_F_248653851_lMw1RUwPLpaBsSCT31eE3ZDY8WkIFpiq.jpg"
        )

        TopContentDetails(
            logoUrl = previewItem.logoUrl,
            name = previewItem.clubName,
            nickName = previewItem.nickName,
            founded = previewItem.founded,
            ground = previewItem.ground,
            league = previewItem.league,
            description = previewItem.description,
            backGround = previewItem.backgroundLogoUrl
        )
    }
}
