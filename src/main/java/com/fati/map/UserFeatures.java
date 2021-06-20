package com.fati.map;

import com.fati.model.TwitterUser;
import com.fati.util.DateUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple10;
import org.apache.flink.util.Collector;

/**
 * author @ fati
 * created @ 19.06.2021
 */

public class UserFeatures implements FlatMapFunction<TwitterUser,
        Tuple10<String, Boolean, Integer, Integer, Integer, Integer, Integer, Integer, Boolean, Boolean>> {

    private static final long serialVersionUID = 4768630241590784948L;

    @Override
    public void flatMap(TwitterUser tu, Collector<Tuple10<String, Boolean, Integer, Integer, Integer, Integer, Integer, Integer, Boolean, Boolean>> collector) {
        collector.collect(new Tuple10<>(tu.getId(), tu.getVerified(), tu.getFollowersCount(), tu.getFriendsCount(),
                tu.getListedCount(), tu.getFavouritesCount(), tu.getStatusesCount(), DateUtils.getYear(tu.getCreatedAt()),
                tu.getGeoEnabled(), tu.getContributorsEnabled()));
    }
}
