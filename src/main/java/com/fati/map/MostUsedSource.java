package com.fati.map;

import com.fati.model.TwitterTweet;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.util.Collector;

/**
 * author @ fati
 * created @ 18.06.2021
 */

public class MostUsedSource implements FlatMapFunction<TwitterTweet, Tuple3<String, String, Integer>> {
    private static final long serialVersionUID = 3497877400678032101L;

    @Override
    public void flatMap(TwitterTweet tt, Collector<Tuple3<String, String, Integer>> collector) {
        String source = tt.getSource().substring(tt.getSource().indexOf('>') + 1, tt.getSource().lastIndexOf('<'));
        collector.collect(new Tuple3<>(tt.getUserId(), source, 1));
    }
}
