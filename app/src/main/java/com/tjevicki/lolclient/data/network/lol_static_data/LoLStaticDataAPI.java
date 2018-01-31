package com.tjevicki.lolclient.data.network.lol_static_data;

import com.tjevicki.lolclient.data.network.lol_static_data.response.Champions;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * @author Tibor Jevicki <tibor.jevicki@sleepnumber.com>
 */

public interface LoLStaticDataAPI {

    @Headers("X-Riot-Token: RGAPI-9765270e-58c9-401f-822c-e139ca233a1e")
    @GET ("lol/platform/v3/champions?freeToPlay=false")
    Call<Champions> getAllChampions();
}
