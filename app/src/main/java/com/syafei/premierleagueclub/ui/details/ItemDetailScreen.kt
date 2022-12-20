package com.syafei.premierleagueclub.ui.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.syafei.premierleagueclub.ui.details.components.TopContentDetails

@Composable
fun ItemDetailScreen(
    name: String,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel()
) {
    viewModel.getClubByName(name)
    when (val clubResult = viewModel.clubViewModel.value) {
        is Result.Exist -> {
            with(clubResult.data) {
                var favorite by remember { mutableStateOf(this.isFavorite) }

                Column(
                    modifier = modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
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

                        //=> nanti

                    }
                }


            }
        }
        Result.NotFound -> Unit
    }

}