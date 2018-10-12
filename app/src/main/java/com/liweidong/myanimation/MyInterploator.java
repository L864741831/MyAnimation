package com.liweidong.myanimation;

import android.animation.TimeInterpolator;

/**
 * Author:李炜东
 * Date:2018/9/17.
 * WX:17337162963
 * Email:18037891572@163.com
 */
/*
倒序
 */
public class MyInterploator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        return 1-input;
    }
}
