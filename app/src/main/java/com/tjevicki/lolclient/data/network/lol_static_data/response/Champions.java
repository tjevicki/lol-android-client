package com.tjevicki.lolclient.data.network.lol_static_data.response;

import com.tjevicki.lolclient.domain.Champion;

import java.util.List;

/**
 * @author Tibor Jevicki <tibor.jevicki@sleepnumber.com>
 */

public class Champions {

    public List<Champion> champions;

    public static class Champion {
        public int id;

        public com.tjevicki.lolclient.domain.Champion toDomain() {
            return new com.tjevicki.lolclient.domain.Champion(id);
        }
    }
}
