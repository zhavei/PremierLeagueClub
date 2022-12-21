package com.syafei.premierleagueclub.ui.favorite

import androidx.lifecycle.ViewModel
import com.syafei.premierleagueclub.data.model.ClubsModel
import com.syafei.premierleagueclub.data.repository.ClubsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(repository: ClubsRepository) : ViewModel() {

    val favoriteClubs: Flow<List<ClubsModel>> = repository.getFavoriteClubsList()

}