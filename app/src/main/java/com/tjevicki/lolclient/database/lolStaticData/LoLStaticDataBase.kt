package com.tjevicki.lolclient.database.lolStaticData

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.tjevicki.lolclient.core.SingleArgumentSingletonHolder
import com.tjevicki.lolclient.database.lolStaticData.LoLStaticDataBase.Companion.create

@Database(entities = [Champion::class], version = 1, exportSchema = false)
abstract class LoLStaticDataBase : RoomDatabase() {
    abstract fun championsStore(): ChampionsStore

    companion object : SingleArgumentSingletonHolder<LoLStaticDataBase, Context>({
        create(it.applicationContext)
    }) {
        private const val DB_NAME = "lol_static_data"

        fun create(context: Context) =
            Room.databaseBuilder(
                    context.applicationContext, LoLStaticDataBase::class.java, DB_NAME)
                    .build()

        fun createInMemory(context: Context) =
            Room.inMemoryDatabaseBuilder(
                    context.applicationContext, LoLStaticDataBase::class.java)
                    .build()
    }
}