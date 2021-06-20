package com.fati.map;

import com.fati.model.TwitterTweet;
import com.fati.util.DateUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.util.Collector;

/**
 * author @ fati
 * created @ 2.06.2021
 */

public class PreferredDay implements FlatMapFunction<TwitterTweet, Tuple3<String, Integer, Integer>> {
    private static final long serialVersionUID = -2597176728591699448L;

    @Override
    public void flatMap(TwitterTweet tt, Collector<Tuple3<String, Integer, Integer>> collector) {
        int preferredDay = DateUtils.getDay(tt.getCreatedAt());
        collector.collect(new Tuple3<>(tt.getUserId(), preferredDay, 1));
    }
}
