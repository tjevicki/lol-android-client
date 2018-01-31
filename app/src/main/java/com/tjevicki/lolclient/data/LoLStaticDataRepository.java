package com.tjevicki.lolclient.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.tjevicki.lolclient.data.network.lol_static_data.LoLStaticDataAPI;
import com.tjevicki.lolclient.data.network.lol_static_data.response.Champions;
import com.tjevicki.lolclient.domain.Champion;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Tibor Jevicki <tibor.jevicki@sleepnumber.com>
 */

public class LoLStaticDataRepository {

    private LoLStaticDataAPI loLStaticDataAPI = new Retrofit.Builder()
            .baseUrl("https://euw1.api.riotgames.com/").addConverterFactory(GsonConverterFactory.create()).build().create(LoLStaticDataAPI.class);

    public LiveData<Champion> getChampion(final int championId) {
        final MutableLiveData<Champion> data = new MutableLiveData<>();

        loLStaticDataAPI.getAllChampions().enqueue(new Callback<Champions>() {
            @Override
            public void onResponse(@NonNull Call<Champions> call, @NonNull Response<Champions> response) {
                data.setValue(response.body().champions.get(
                        new Random().nextInt(response.body().champions.size())).toDomain());

                int a = 0;
                a++;
            }

            @Override
            public void onFailure(@NonNull Call<Champions> call, @NonNull Throwable t) {
                int a = 0;
                a++;
            }
        });

        return data;
    }
}
