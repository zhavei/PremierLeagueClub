package com.syafei.premierleagueclub.ui.home

import androidx.lifecycle.ViewModel
import com.syafei.premierleagueclub.data.model.ClubsModel
import com.syafei.premierleagueclub.data.repository.ClubsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ClubsRepository
) : ViewModel() {

    fun listOfClubs(name: String): Flow<List<ClubsModel>> {
        return repository.getClubsListByName(name)
    }

}