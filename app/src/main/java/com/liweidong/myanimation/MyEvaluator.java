package com.liweidong.myanimation;

import android.animation.TypeEvaluator;

/**
 * Author:李炜东
 * Date:2018/9/17.
 * WX:17337162963
 * Email:18037891572@163.com
 */

public class MyEvaluator implements TypeEvaluator<Integer> {
    @Override
    /*
    其中fraction就是加速器中的返回值，表示当前动画的数值进度，百分制的小数表示。
startValue和endValue分别对应ofInt(int start,int end)中的start和end的数值
     */
    //进度系数(0-1)，开始值，结束值
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        return (int)(200+startInt + fraction * (endValue - startInt));
    }
}
