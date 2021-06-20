package com.fati.map;

import com.fati.model.TwitterExtractedFeatures;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple25;
import org.apache.flink.util.Collector;

/**
 * author @ fati
 * created @ 19.06.2021
 */

public class Tuple2POJO implements FlatMapFunction
        <Tuple25<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer, Integer, Integer, String, Integer, Boolean, Integer, Integer, Integer, Integer, Integer, Integer, Boolean, Boolean>,
                TwitterExtractedFeatures> {

    private static final long serialVersionUID = -6538987945584087964L;

    @Override
    public void flatMap(Tuple25<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer, Integer, Integer, String, Integer, Boolean, Integer, Integer, Integer, Integer, Integer, Integer, Boolean, Boolean> val,
                        Collector<TwitterExtractedFeatures> collector) {
        collector.collect(new TwitterExtractedFeatures(val.f0, val.f1, val.f2, val.f3, val.f4, val.f5, val.f6, val.f7,
                val.f8, val.f9, val.f10, val.f11, val.f12, val.f13, val.f14, val.f15, val.f16, val.f17, val.f18, val.f19,
                val.f20, val.f21, val.f22, val.f23, val.f24));
    }
}
