package com.syafei.premierleagueclub.ui.details

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.syafei.premierleagueclub.ui.details.components.TopContentDetails

@Composable
fun ItemDetailScreen(
    name: String,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel()
) {

    LaunchedEffect(true) {
        viewModel.getClubByName(name)

    }

    when (val clubResult = viewModel.clubViewModel.value) {
        is Result.Exist -> {
            with(clubResult.data) {
                var favorite by remember { mutableStateOf(this.isFavorite) }

                    Box(
                        modifier = modifier.fillMaxSize()
                    ) {

                        TopContentDetails(
                            logoUrl = logoUrl,
                            name = name,
                            nickName = nickName,
                            founded = founded,
                            ground = ground,
                            league = league,
                            description = description,
                            backGround = backgroundLogoUrl
                        )

                        FloatingActionButton(
                            onClick = {
                                favorite = !favorite
                                viewModel.addToFavorite(clubResult.data.apply {
                                    isFavorite = !isFavorite
                                })
                            },
                            modifier = modifier
                                .align(Alignment.CenterEnd)
                                .padding(24.dp)
                                .padding(bottom = 65.dp),
                            backgroundColor = Color.DarkGray
                        ) {
                            Icon(
                                imageVector =
                                if (favorite) {
                                    Icons.Filled.Favorite
                                } else {
                                    Icons.Outlined.FavoriteBorder
                                },
                                contentDescription = "icon Favorite",
                                tint = Color.White
                            )
                        }
                    }
            }
        }
        Result.NotFound -> Unit
    }
}