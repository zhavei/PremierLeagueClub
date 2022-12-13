package com.syafei.premierleagueclub.data.repository

import android.content.Context
import com.syafei.premierleagueclub.R
import com.syafei.premierleagueclub.data.localdatabase.ClubsDao
import com.syafei.premierleagueclub.data.model.ClubsModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ClubsRepositoryImpl @Inject constructor(
    private val context: Context,
    private val clubsDao: ClubsDao

) : ClubsRepository {

    init {
        CoroutineScope(Dispatchers.IO).launch {
            populateDb()
        }
    }

    override fun getClubsList(): Flow<List<ClubsModel>> {
        return clubsDao.getClubsList()
    }

    override fun getClubsListByName(name: String): Flow<List<ClubsModel>> {
        return clubsDao.getListOfClubByName("%$name%")
    }

    override fun getFavoriteClubsList(): Flow<List<ClubsModel>> {
        return clubsDao.getFavoriteListClub()
    }

    override fun getClubByName(name: String): ClubsModel {
        return clubsDao.getClubByName(name)
    }

    override suspend fun addOrRemoveFromFavorite(clubs: ClubsModel) {
        return clubsDao.addToFavorite(clubs)
    }

    override suspend fun populateDb() {
        clubsDao.insertListClubs(dataDummy())
    }

    //next with API
    private fun dataDummy(): List<ClubsModel> {

        val clubName = context.resources.getStringArray(R.array.club_name)
        val logoUrl = context.resources.getStringArray(R.array.logo_url)
        val nickName = context.resources.getStringArray(R.array.nick_name)
        val founded = context.resources.getStringArray(R.array.founded).map { it.toInt() }
        val ground = context.resources.getStringArray(R.array.ground)
        val capacity = context.resources.getStringArray(R.array.capacity).map { it.toInt() }
        val league = context.resources.getStringArray(R.array.league)
        val description = context.resources.getStringArray(R.array.description)


        val clubsList = arrayListOf<ClubsModel>()

        for (i in clubName.indices) {
            clubsList.add(
                ClubsModel(
                    clubName = clubName[i],
                    logoUrl = logoUrl[i],
                    nickName = nickName[i],
                    founded = founded[i],
                    ground = ground[i],
                    capacity = capacity[i],
                    league = league[i],
                    description = description[i]
                )
            )
        }
        return clubsList
    }
}