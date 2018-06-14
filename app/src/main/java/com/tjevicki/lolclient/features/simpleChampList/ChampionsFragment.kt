package com.tjevicki.lolclient.features.simpleChampList

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tjevicki.lolclient.R

class ChampionsFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =

            inflater.inflate(R.layout.champions_fragment, container, false)
}