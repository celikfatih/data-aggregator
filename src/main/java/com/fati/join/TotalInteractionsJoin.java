package com.fati.join;

import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.tuple.Tuple12;
import org.apache.flink.api.java.tuple.Tuple13;
import org.apache.flink.api.java.tuple.Tuple2;

/**
 * author @ fati
 * created @ 19.06.2021
 */

public class TotalInteractionsJoin implements JoinFunction
        <Tuple12<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer>,
        Tuple2<String, Integer>, Tuple13<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer, Integer>> {

    private static final long serialVersionUID = -2713874062449559145L;

    @Override
    public Tuple13<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer, Integer> join(
            Tuple12<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer> val0, Tuple2<String, Integer> val1) {
        return new Tuple13<>(val0.f0, val0.f1, val0.f2, val0.f3, val0.f4, val0.f5, val0.f6, val0.f7, val0.f8, val0.f9, val0.f10,
                val0.f11, val1.f1);
    }
}
