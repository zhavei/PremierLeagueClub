package com.syafei.premierleagueclub.di

import android.content.Context
import androidx.room.Room
import com.syafei.premierleagueclub.data.localdatabase.ClubsDao
import com.syafei.premierleagueclub.data.localdatabase.ClubsDb
import com.syafei.premierleagueclub.data.repository.ClubsRepository
import com.syafei.premierleagueclub.data.repository.ClubsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonAppModule {

    @Provides
    @Singleton
    fun provideClubsDao(clubsDb: ClubsDb) = clubsDb.clubsDao()

    @Provides
    @Singleton
    fun provideClubDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, ClubsDb::class.java, "clubs_db").build()


    @Provides
    @Singleton
    fun provideClubsRepository(
        @ApplicationContext context: Context,
        clubsDao: ClubsDao
    ): ClubsRepository {
        return ClubsRepositoryImpl(context, clubsDao)
    }

}