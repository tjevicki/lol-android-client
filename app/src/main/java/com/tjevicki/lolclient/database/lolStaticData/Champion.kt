package com.tjevicki.lolclient.database.lolStaticData

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "champions")
data class Champion(@PrimaryKey val id: Int, val name: String)