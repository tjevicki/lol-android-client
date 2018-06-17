package com.tjevicki.lolclient.features.simpleChampList

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import com.tjevicki.lolclient.R
import com.tjevicki.lolclient.database.lolStaticData.Champion

class ChampionsFragment : Fragment() {
    @BindView(R.id.list_champions) lateinit var listChampions: RecyclerView

    private val championsAdapter = ChampionsAdapter()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.champions_fragment, container, false)
        ButterKnife.bind(this, view)

        initChampionsList()

        return view
    }

    private fun initChampionsList() {
        listChampions.layoutManager = LinearLayoutManager(context)
        listChampions.adapter = championsAdapter

        championsAdapter.resetChampions(createFakeChampions())
    }

    private fun createFakeChampions() =
            listOf<Champion>(
                    Champion(1, "Diana"),
                    Champion(2, "Ahri"),
                    Champion(3, "Twisted Fate"),
                    Champion(4, "Annie"),
                    Champion(5, "Akali"),
                    Champion(6, "Anivia"),
                    Champion(7, "Yasuo"),
                    Champion(8, "Zed"),
                    Champion(9, "Viktor"),
                    Champion(10, "Fizz"),
                    Champion(11, "Heimerdinger"),
                    Champion(12, "Ziggs"),
                    Champion(13, "Kai'sa"),
                    Champion(14, "Syndra"),
                    Champion(15, "Ekko"),
                    Champion(16,"Cho'gath" )
            )
}