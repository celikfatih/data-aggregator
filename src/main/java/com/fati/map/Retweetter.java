package com.fati.map;

import com.fati.model.TwitterTweet;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.util.Collector;

/**
 * author @ fati
 * created @ 18.06.2021
 */

public class Retweetter implements FlatMapFunction<TwitterTweet, Tuple3<String, Boolean, Integer>> {
    private static final long serialVersionUID = 3963945266192758045L;

    @Override
    public void flatMap(TwitterTweet tt, Collector<Tuple3<String, Boolean, Integer>> collector) {
        collector.collect(new Tuple3<>(tt.getUserId(), tt.getRetweet(), 1));
    }
}
