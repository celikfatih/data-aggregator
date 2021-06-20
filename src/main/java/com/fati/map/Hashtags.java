package com.fati.map;

import com.fati.model.TwitterTweet;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

import java.util.Objects;

/**
 * author @ fati
 * created @ 18.06.2021
 */

public class Hashtags implements FlatMapFunction<TwitterTweet, Tuple2<String, Integer>> {
    private static final long serialVersionUID = -7810463180636821230L;

    @Override
    public void flatMap(TwitterTweet tt, Collector<Tuple2<String, Integer>> collector) {
        int hashtagSize = Objects.nonNull(tt.getHashtags()) ? tt.getHashtags().size() : 0;
        collector.collect(new Tuple2<>(tt.getUserId(), hashtagSize));
    }
}
