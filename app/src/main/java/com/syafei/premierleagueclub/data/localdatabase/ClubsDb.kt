package com.syafei.premierleagueclub.data.localdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.syafei.premierleagueclub.data.model.ClubsModel


@Database(
    entities = [ClubsModel::class],
    version = 1
)
abstract class ClubsDb : RoomDatabase() {
    abstract fun clubsDao(): ClubsDao

}