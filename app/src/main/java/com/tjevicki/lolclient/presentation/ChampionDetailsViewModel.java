package com.tjevicki.lolclient.presentation;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.tjevicki.lolclient.data.LoLStaticDataRepository;
import com.tjevicki.lolclient.domain.Champion;

/**
 * @author Tibor Jevicki <tibor.jevicki@sleepnumber.com>
 */

public class ChampionDetailsViewModel extends ViewModel {
    private LiveData<Champion> champion;

    private LoLStaticDataRepository loLStaticDataRepository = new LoLStaticDataRepository();

    public void init(int championId) {
        if (champion != null) {
            return;
        }

        champion = loLStaticDataRepository.getChampion(championId);
    }

    public LiveData<Champion> getChampion() {
        return champion;
    }
}
