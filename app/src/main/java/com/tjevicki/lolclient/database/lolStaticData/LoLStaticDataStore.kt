package com.tjevicki.lolclient.database.lolStaticData

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query

@Dao
interface LoLStaticDataStore {

    @Query("SELECT * FROM champions") fun getChampions(): List<Champion>
    @Query("SELECT * FROM champions WHERE id = :id") fun getChampion(id: Int): Champion
}