package com.tjevicki.lolclient.database.lolStaticData

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.tjevicki.lolclient.core.SingleArgumentSingletonHolder

@Database(entities = [Champion::class], version = 1)
abstract class LoLStaticDataBase : RoomDatabase() {
    abstract fun lolStaticDataStore(): LoLStaticDataStore

    companion object : SingleArgumentSingletonHolder<LoLStaticDataBase, Context>({
        Room.databaseBuilder(
                it.applicationContext, LoLStaticDataBase::class.java, "lol_static_data")
                .build()
    })
}