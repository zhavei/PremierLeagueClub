package com.syafei.premierleagueclub.data.localdatabase

import androidx.room.*
import com.syafei.premierleagueclub.data.model.ClubsModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ClubsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertListClubs(clubs: List<ClubsModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorite(clubs: ClubsModel)

    @Query("SELECT * FROM clubs_table ORDER BY clubName ASC")
    fun getClubsList(): Flow<List<ClubsModel>>

    @Query("SELECT * FROM clubs_table WHERE isFavorite = 1 ORDER BY clubName ASC")
    fun getFavoriteListClub(): Flow<List<ClubsModel>>

    @Query("SELECT * FROM clubs_table WHERE clubName LIke :clubName ORDER BY clubName ASC")
    fun getListOfClubByName(clubName: String): Flow<List<ClubsModel>>

    @Query("SELECT * FROM clubs_table WHERE clubName =:clubName")
    fun getClubByName(clubName: String): ClubsModel

    @Update
    suspend fun updateClubsModel(anime: ClubsModel)

}