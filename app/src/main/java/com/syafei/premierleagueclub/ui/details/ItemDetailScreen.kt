package com.syafei.premierleagueclub.ui.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

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



                }


            }
        }
        Result.NotFound -> Unit
    }

}