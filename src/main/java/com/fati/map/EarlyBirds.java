package com.fati.map;

import com.fati.model.TwitterTweet;
import com.fati.util.DateUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.util.Collector;

/**
 * author @ fati
 * created @ 17.06.2021
 */

public class EarlyBirds implements FlatMapFunction<TwitterTweet, Tuple3<String, String, Integer>> {
    private static final long serialVersionUID = 5945420498506727079L;

    @Override
    public void flatMap(TwitterTweet tt, Collector<Tuple3<String, String, Integer>> collector) {
        int hour = DateUtils.getHour(tt.getCreatedAt());
        String partOfDay = (hour > 4 && hour < 17) ? "earlyBird" : "nightOwl";
        collector.collect(new Tuple3<>(tt.getUserId(), partOfDay, 1));
    }
}
