package com.tjevicki.lolclient.features.simpleChampList

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.tjevicki.lolclient.R
import com.tjevicki.lolclient.database.lolStaticData.Champion

class ChampionsAdapter : RecyclerView.Adapter<ChampionViewHolder>() {
    private var champions: MutableList<Champion> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChampionViewHolder =
            ChampionViewHolder(
                    LayoutInflater.from(
                            parent.context).inflate(R.layout.champion_item, parent, false))

    override fun getItemCount(): Int = champions.size

    override fun onBindViewHolder(holder: ChampionViewHolder, position: Int) =
            holder.bind(champions[position])

    fun resetChampions(newChampions: List<Champion>) {
        champions.clear()
        champions.addAll(newChampions)

        notifyDataSetChanged()
    }
}