package com.syafei.premierleagueclub.ui.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syafei.premierleagueclub.data.model.ClubsModel
import com.syafei.premierleagueclub.data.repository.ClubsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: ClubsRepository
) : ViewModel() {

    private val _clubViewModel: MutableState<Result> = mutableStateOf(
        Result.NotFound
    )
    val clubViewModel: State<Result> get() = _clubViewModel

    fun getClubByName(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _clubViewModel.value = Result.Exist(repository.getClubByName(name))
        }
    }

    fun addToFavorite(club: ClubsModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addOrRemoveFromFavorite(club)
        }
    }

}

sealed class Result() {
    object NotFound : Result()
    data class Exist(val data: ClubsModel) : Result()
}