package com.tjevicki.lolclient.database.lolStaticData

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ChampionsStore {

    @Query("SELECT * FROM champions") fun getChampions(): List<Champion>
    @Query("SELECT * FROM champions WHERE id = :id") fun getChampion(id: Int): Champion

    @Insert fun storeChampions(champions: List<Champion>)
}