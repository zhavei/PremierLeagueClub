package com.syafei.premierleagueclub.ui.home.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeSearchBar(
    searchQuery: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = searchQuery,
        onValueChange = { newSearchQuery ->
            onChange(newSearchQuery)
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        label = {
            Text(text = "Search your Favorite Club")
        },
        singleLine = true,
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Icon Search",
                tint = Color.White
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Gray,
            textColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedLabelColor = Color.White,
            focusedLabelColor = Color.White
        ),
        shape = RoundedCornerShape(10.dp)
    )
}