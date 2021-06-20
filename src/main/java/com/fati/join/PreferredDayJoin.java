package com.fati.join;

import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple6;
import org.apache.flink.api.java.tuple.Tuple8;

/**
 * author @ fati
 * created @ 19.06.2021
 */

public class PreferredDayJoin implements JoinFunction<Tuple6<String, String, Integer, Integer, String, Integer>,
        Tuple3<String, Integer, Integer>, Tuple8<String, String, Integer, Integer, String, Integer, Integer, Integer>> {

    private static final long serialVersionUID = -1824466438379003206L;

    @Override
    public Tuple8<String, String, Integer, Integer, String, Integer, Integer, Integer> join(Tuple6<String, String, Integer, Integer, String, Integer> val0,
                                                                                           Tuple3<String, Integer, Integer> val1) {
        return new Tuple8<>(val0.f0, val0.f1, val0.f2, val0.f3, val0.f4, val0.f5, val1.f1, val1.f2);
    }
}
