package com.syafei.premierleagueclub.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "clubs_table")
data class ClubsModel(
    @PrimaryKey
    val clubName: String,
    val logoUrl: String,
    val nickName: String,
    val founded: Int,
    val ground: String,
    val capacity: Int,
    val league: String,
    val description: String,
    var isFavorite: Boolean = false

) : Parcelable