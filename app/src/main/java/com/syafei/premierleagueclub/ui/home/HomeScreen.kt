package com.syafei.premierleagueclub.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.syafei.premierleagueclub.ui.home.component.ClubsLazyColumn
import com.syafei.premierleagueclub.ui.home.component.HomeSearchBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
    onClicked: (String) -> Unit
) {

    var searchQuery by remember {
        mutableStateOf("")
    }
    val getData = viewModel.listOfClubs(searchQuery).collectAsState(initial = listOf())
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {

        HomeSearchBar(searchQuery, { getSearch ->
            searchQuery = getSearch
        })
        ClubsLazyColumn(
            clubNameList = getData.value,
            onClicked = {
            onClicked(it)
        })
    }
}