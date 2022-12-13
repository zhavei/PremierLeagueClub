package com.syafei.premierleagueclub.data.repository

import com.syafei.premierleagueclub.data.model.ClubsModel
import kotlinx.coroutines.flow.Flow

interface ClubsRepository {

    fun getClubsList(): Flow<List<ClubsModel>>

    fun getClubsListByName(name: String): Flow<List<ClubsModel>>

    fun getFavoriteClubsList(): Flow<List<ClubsModel>>

    fun getClubByName(name: String): ClubsModel

    suspend fun addOrRemoveFromFavorite(clubs: ClubsModel)

    suspend fun populateDb()

}