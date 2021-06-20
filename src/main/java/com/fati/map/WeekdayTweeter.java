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

public class WeekdayTweeter implements FlatMapFunction<TwitterTweet, Tuple3<String, String, Integer>> {
    private static final long serialVersionUID = -7554836810083078808L;

    @Override
    public void flatMap(TwitterTweet tt, Collector<Tuple3<String, String, Integer>> collector) {
        int day = DateUtils.getDay(tt.getCreatedAt());
        String partOfWeek = (day > 1 && day < 7) ? "weekday" : "weekend";
        collector.collect(new Tuple3<>(tt.getUserId(), partOfWeek, 1));
    }
}
