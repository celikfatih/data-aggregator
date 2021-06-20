package com.fati.join;

import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.tuple.Tuple10;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple8;

/**
 * author @ fati
 * created @ 19.06.2021
 */

public class PreferredTimeOfDayJoin implements JoinFunction<Tuple8<String, String, Integer, Integer, String, Integer, Integer, Integer>,
        Tuple3<String, Integer, Integer>, Tuple10<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer>> {

    private static final long serialVersionUID = -4901979562267533782L;

    @Override
    public Tuple10<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer> join(
            Tuple8<String, String, Integer, Integer, String, Integer, Integer, Integer> val0,
            Tuple3<String, Integer, Integer> val1) {
        return new Tuple10<>(val0.f0, val0.f1, val0.f2, val0.f3, val0.f4, val0.f5, val0.f6, val0.f7, val1.f1, val1.f2);
    }
}
