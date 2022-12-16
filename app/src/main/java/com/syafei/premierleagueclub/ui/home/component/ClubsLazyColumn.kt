package com.syafei.premierleagueclub.ui.home.component

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.syafei.premierleagueclub.R
import com.syafei.premierleagueclub.data.model.ClubsModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ClubsLazyColumn(
    clubNameList: List<ClubsModel>,
    onClicked: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val listState = rememberLazyGridState()
    val showButton by remember {
        derivedStateOf { listState.firstVisibleItemIndex > 0 }
    }

    //surround with box if list is empty
    Box(modifier = modifier.fillMaxSize()) {

        if (clubNameList.isEmpty()) {
            Text(
                text = stringResource(R.string.empty),
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LazyVerticalGrid(
                state = listState,
                columns = GridCells.Adaptive(150.dp),
                contentPadding = PaddingValues(
                    top = 0.dp,
                    bottom = 16.dp,
                    start = 8.dp,
                    end = 8.dp
                ),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {

                items(clubNameList) { data: ClubsModel ->
                    ClubsRowItems(
                        clubName = data.clubName,
                        ground = data.ground,
                        logoUrl = data.logoUrl,
                        backgroundLogoUrl = data.backgroundLogoUrl,
                        onClicked = { onClicked(it) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .animateItemPlacement(tween(durationMillis = 100))
                    )
                }
            }

            AnimatedVisibility(
                visible = showButton,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically(),
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .align(Alignment.BottomCenter)
            ) {
                ScrollToTopButton(onClick = {
                    scope.launch {
                        listState.animateScrollToItem(0)
                    }
                })
            }

        }
    }
}


@Composable
fun ScrollToTopButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .shadow(elevation = 10.dp, shape = CircleShape)
            .clip(shape = CircleShape)
            .size(56.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = MaterialTheme.colors.primary
        )
    ) {

        Icon(
            imageVector = Icons.Filled.KeyboardArrowUp,
            contentDescription = null
        )
    }
}
