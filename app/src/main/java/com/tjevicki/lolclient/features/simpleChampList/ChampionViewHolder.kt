package com.tjevicki.lolclient.features.simpleChampList

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.tjevicki.lolclient.R
import com.tjevicki.lolclient.database.lolStaticData.Champion

class ChampionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    @BindView(R.id.txt_champion_name) lateinit var txtChampionName: TextView

    init {
        ButterKnife.bind(this, itemView)
    }

    fun bind(champion: Champion) {
        txtChampionName.text = champion.name
    }
}