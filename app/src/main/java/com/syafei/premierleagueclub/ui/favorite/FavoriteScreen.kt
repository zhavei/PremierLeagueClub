package com.syafei.premierleagueclub.ui.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.syafei.premierleagueclub.ui.home.component.ClubsLazyColumn

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    onCLick: (String) -> Unit
) {
    val collectData = viewModel.favoriteClubs.collectAsState(initial = listOf())

    Column(
        modifier = modifier.fillMaxSize().padding(top = 15.dp)
    ) {
        ClubsLazyColumn(clubNameList = collectData.value, onClicked = { item ->
            onCLick(item)
        })

    }


}