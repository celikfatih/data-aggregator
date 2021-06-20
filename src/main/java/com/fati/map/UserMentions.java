package com.fati.map;

import com.fati.model.TwitterTweet;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

/**
 * author @ fati
 * created @ 18.06.2021
 */

public class UserMentions implements FlatMapFunction<TwitterTweet, Tuple2<String, Integer>> {
    private static final long serialVersionUID = -6586208959171673068L;

    @Override
    public void flatMap(TwitterTweet tt, Collector<Tuple2<String, Integer>> collector) {
        collector.collect(new Tuple2<>(tt.getUserId(), tt.getUserMentionsCount()));
    }
}
