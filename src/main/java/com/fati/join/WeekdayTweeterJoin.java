package com.fati.join;

import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.tuple.Tuple14;
import org.apache.flink.api.java.tuple.Tuple16;
import org.apache.flink.api.java.tuple.Tuple3;

/**
 * author @ fati
 * created @ 19.06.2021
 */

public class WeekdayTweeterJoin implements JoinFunction
        <Tuple14<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer, Integer, Integer>,
        Tuple3<String, String, Integer>, Tuple16<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer, Integer, Integer, String, Integer>> {

    private static final long serialVersionUID = -1848648215972422352L;

    @Override
    public Tuple16<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer, Integer, Integer, String, Integer> join(
            Tuple14<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer, Integer, Integer> val0,
            Tuple3<String, String, Integer> val1) {
        return new Tuple16<>(val0.f0, val0.f1, val0.f2, val0.f3, val0.f4, val0.f5, val0.f6, val0.f7, val0.f8, val0.f9,
                val0.f10, val0.f11, val0.f12, val0.f13, val1.f1, val1.f2);
    }
}
