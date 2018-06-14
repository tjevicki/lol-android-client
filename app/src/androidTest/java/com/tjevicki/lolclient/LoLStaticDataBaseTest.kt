package com.tjevicki.lolclient

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.tjevicki.lolclient.database.lolStaticData.Champion
import com.tjevicki.lolclient.database.lolStaticData.ChampionsStore
import com.tjevicki.lolclient.database.lolStaticData.LoLStaticDataBase
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoLStaticDataBaseTest {
    lateinit var loLStaticDataBase: LoLStaticDataBase
    lateinit var championsStore: ChampionsStore

    @Before
    fun setup() {
        loLStaticDataBase =
                LoLStaticDataBase.createInMemory(InstrumentationRegistry.getTargetContext())

        championsStore = loLStaticDataBase.championsStore()
    }

    @After
    fun tearDown() {
        loLStaticDataBase.close()
    }

    @Test
    fun basicCrud() {
        // Check if database initialized correctly
        assertEquals(0, championsStore.getChampions().size)

        // Check if populating works fine
        val champions = listOf(
                Champion(1, "Quinn"),
                Champion(2, "Diana"),
                Champion(3, "Nasus"),
                Champion(4, "Ahri"))

        championsStore.storeChampions(champions)

        assertEquals(4, championsStore.getChampions().size)
    }
}