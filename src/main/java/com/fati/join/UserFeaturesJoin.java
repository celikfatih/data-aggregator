package com.fati.join;

import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.java.tuple.Tuple10;
import org.apache.flink.api.java.tuple.Tuple16;
import org.apache.flink.api.java.tuple.Tuple25;

/**
 * author @ fati
 * created @ 19.06.2021
 */

public class UserFeaturesJoin implements JoinFunction
        <Tuple16<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer, Integer, Integer, String, Integer>,
                Tuple10<String, Boolean, Integer, Integer, Integer, Integer, Integer, Integer, Boolean, Boolean>,
                Tuple25<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer, Integer, Integer, String, Integer, Boolean, Integer, Integer, Integer, Integer, Integer, Integer, Boolean, Boolean>> {

    private static final long serialVersionUID = -160389872386770733L;

    @Override
    public Tuple25<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer, Integer, Integer, String, Integer, Boolean, Integer, Integer, Integer, Integer, Integer, Integer, Boolean, Boolean> join(
            Tuple16<String, String, Integer, Integer, String, Integer, Integer, Integer, Integer, Integer, Boolean, Integer, Integer, Integer, String, Integer> val0,
            Tuple10<String, Boolean, Integer, Integer, Integer, Integer, Integer, Integer, Boolean, Boolean> val1) {
        return new Tuple25<>(val0.f0, val0.f1, val0.f2, val0.f3, val0.f4, val0.f5, val0.f6, val0.f7, val0.f8, val0.f9,
                val0.f10, val0.f11, val0.f12, val0.f13, val0.f14, val0.f15, val1.f1, val1.f2, val1.f3, val1.f4, val1.f5,
                val1.f6, val1.f7, val1.f8, val1.f9);
    }
}
