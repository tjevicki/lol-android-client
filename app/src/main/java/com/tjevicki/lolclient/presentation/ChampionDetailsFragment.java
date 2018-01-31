package com.tjevicki.lolclient.presentation;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tjevicki.lolclient.R;
import com.tjevicki.lolclient.domain.Champion;

/**
 * Created by tjevi on 29-Jan-18.
 */

public class ChampionDetailsFragment extends Fragment {

    private static final String KEY_CHAMPION_ID = "champion_id";

    private ChampionDetailsViewModel viewModel;

    private TextView txtChampionId;

    public static ChampionDetailsFragment newInstance(int championId) {
        ChampionDetailsFragment instance = new ChampionDetailsFragment();

        Bundle arguments = new Bundle();
        arguments.putInt(KEY_CHAMPION_ID, championId);
        instance.setArguments(arguments);

        return instance;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int championId = getArguments().getInt(KEY_CHAMPION_ID);

        viewModel = ViewModelProviders.of(this).get(ChampionDetailsViewModel.class);
        viewModel.init(championId);

        viewModel.getChampion().observe(this, new Observer<Champion>() {
            @Override
            public void onChanged(@Nullable Champion champion) {
                updateUI(champion);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.champion_details_fragment, container, false);

        txtChampionId = view.findViewById(R.id.txt_champion_id);

        return view;
    }

    private void updateUI(Champion champion) {
        txtChampionId.setText(String.valueOf(champion.getId()));
    }
}
