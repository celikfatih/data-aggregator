package com.fati.join;

import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.tuple.Tuple10;
import org.apache.flink.api.java.tuple.Tuple12;
import org.apache.flink.api.java.tuple.Tuple3;

/**
 * author @ fati
 * created @ 19.06.2021
 */

public class RetweetterJoin implements JoinFunction<Tuple10<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer>,
        Tuple3<String, Boolean, Integer>, Tuple12<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer>> {

    private static final long serialVersionUID = -7167458547130231530L;

    @Override
    public Tuple12<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer> join(
            Tuple10<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer> val0,
            Tuple3<String, Boolean, Integer> val1) {
        return new Tuple12<>(val0.f0, val0.f1, val0.f2, val0.f3, val0.f4, val0.f5, val0.f6, val0.f7, val0.f8, val0.f9, val1.f1, val1.f2);
    }
}
