package com.fati.join;

import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;

/**
 * author @ fati
 * created @ 19.06.2021
 */

public class EarlyBirdHashtagsJoin implements JoinFunction<Tuple3<String, String, Integer>,
        Tuple2<String, Integer>, Tuple4<String, String, Integer, Integer>> {

    private static final long serialVersionUID = 4456688057797935139L;

    @Override
    public Tuple4<String, String, Integer, Integer> join(Tuple3<String, String, Integer> val0,
                                                         Tuple2<String, Integer> val1) {
        return new Tuple4<>(val0.f0, val0.f1, val0.f2, val1.f1);
    }
}
