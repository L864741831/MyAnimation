package com.liweidong.myanimation;

import android.animation.TypeEvaluator;

/**
 * Author:李炜东
 * Date:2018/9/17.
 * WX:17337162963
 * Email:18037891572@163.com
 */

/*
倒序输出
 */
public class ReverseEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        return (int) (endValue - fraction * (endValue - startInt));
    }
}
