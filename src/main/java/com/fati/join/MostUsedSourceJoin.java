package com.fati.join;

import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.api.java.tuple.Tuple6;

/**
 * author @ fati
 * created @ 19.06.2021
 */

public class MostUsedSourceJoin implements JoinFunction<Tuple4<String, String, Integer, Integer>,
        Tuple3<String, String, Integer>, Tuple6<String, String, Integer, Integer, String, Integer>> {

    private static final long serialVersionUID = 7168042761258159921L;

    @Override
    public Tuple6<String, String, Integer, Integer, String, Integer> join(Tuple4<String, String, Integer, Integer> val0,
                                                                          Tuple3<String, String, Integer> val1) {
        return new Tuple6<>(val0.f0, val0.f1, val0.f2, val0.f3, val1.f1, val1.f2);
    }
}
