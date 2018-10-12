package com.liweidong.myanimation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author:李炜东
 * Date:2018/9/13.
 * WX:17337162963
 * Email:18037891572@163.com
 */

public class Animation2 extends AppCompatActivity implements View.OnClickListener {

    //开始补间动画
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tv)
    TextView tv;

    //开始属性动画，取消属性动画，取消属性边花监听
    @BindView(R.id.btn_ValueAnimator)
    Button btnValueAnimator;
    @BindView(R.id.tv_ValueAnimator)
    TextView tvValueAnimator;

    ValueAnimator animator;

    @BindView(R.id.btn_ValueAnimator_cancel)
    Button btnValueAnimatorCancel;
    @BindView(R.id.btn_ValueAnimator_remove)
    Button btnValueAnimatorRemove;

    //克隆开始动画，取消动画
    @BindView(R.id.btn_ValueAnimator_clone)
    Button btnValueAnimatorClone;
    @BindView(R.id.tv_ValueAnimator_clone)
    TextView tvValueAnimatorClone;
    @BindView(R.id.btn_ValueAnimator_cancel_clone)
    Button btnValueAnimatorCancelClone;

    ValueAnimator repeatAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation2);

        //绑定初始化ButterKnife（一定要在setContentView之后）
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn, R.id.tv,
            R.id.btn_ValueAnimator, R.id.tv_ValueAnimator, R.id.btn_ValueAnimator_cancel, R.id.btn_ValueAnimator_remove,
            R.id.btn_ValueAnimator_clone,R.id.btn_ValueAnimator_cancel_clone,R.id.tv_ValueAnimator_clone
    })
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                final TranslateAnimation animation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 400,
                        Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 400);
                animation.setFillAfter(true);
                animation.setDuration(1000);
                tv.startAnimation(animation);
                break;
            case R.id.tv:
                Toast.makeText(Animation2.this, "anim clicked me", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_ValueAnimator:
                doAnimation();
                break;
            case R.id.tv_ValueAnimator:
                Toast.makeText(Animation2.this, "ValueAnimator clicked me", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_ValueAnimator_cancel:
                animator.cancel();
                break;
            case R.id.btn_ValueAnimator_remove:
                /*
                针对AnimatorUpdateListener和AnimatorListener，每个监听器都有两个方法来移除；
                removeListener(AnimatorListener listener)用于在animator中移除指定的监听器，
                而removeAllListeners()用于移除animator中所有的AnimatorListener监听器；
                 */
                animator.removeAllUpdateListeners();
                break;
            case R.id.btn_ValueAnimator_clone:
                repeatAnimator = doRepeatAnim();
                //克隆一个新的ValueAnimator，然后开始动画
                ValueAnimator newAnimator = repeatAnimator.clone();
                newAnimator.setStartDelay(1000);
                newAnimator.start();
                break;
            case R.id.btn_ValueAnimator_cancel_clone:
                repeatAnimator.removeAllUpdateListeners();

                repeatAnimator.cancel();
                break;
            case R.id.tv_ValueAnimator_clone:
                Toast.makeText(Animation2.this, "clone clicked me", Toast.LENGTH_SHORT).show();
                break;
        }
    }


/*
可以设置多个值成为连续动画

public static ValueAnimator ofInt(int... values)
public static ValueAnimator ofFloat(float... values)

设置动画时长，单位是毫秒
ValueAnimator setDuration(long duration)

获取ValueAnimator在运动时，当前运动点的值
Object getAnimatedValue();

开始动画
void start()

设置循环次数,设置为INFINITE表示无限循环
void setRepeatCount(int value)

设置循环模式
value取值有RESTART，REVERSE，
void setRepeatMode(int value)

取消动画
void cancel()
 */

    private void doAnimation() {
        animator = ValueAnimator.ofFloat(0f, 400f, 50f, 300f);
        animator.setDuration(3000);

        /*
        AnimatorUpdateListener就是监听动画的实时变化状态
         */
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float curValueFloat = (Float) animation.getAnimatedValue();
                int curValue = curValueFloat.intValue();
                tvValueAnimator.layout(curValue, curValue, curValue + tvValueAnimator.getWidth(), curValue + tvValueAnimator.getHeight());
            }
        });

/*
主要是监听Animation的四个状态，start、end、cancel、repeat；
当动画开始时，会调用onAnimationStart(Animator animation)方法，
当动画结束时调用onAnimationEnd(Animator animation)，
当动画取消时，调用onAnimationCancel(Animator animation)函数，
当动画重复时，会调用onAnimationRepeat(Animator animation)函数。
 */
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d("qijian", "animation start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("qijian", "animation end");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d("qijian", "animation cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("qijian", "animation repeat");
            }
        });


        //返回
        animator.setRepeatMode(ValueAnimator.REVERSE);
        //无限次
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(1000);
        animator.start();
    }


    /**
     * 其他函数
     * <p>
     * 延时多久时间开始，单位是毫秒
     * public void setStartDelay(long startDelay)
     * <p>
     * 完全克隆一个ValueAnimator实例，包括它所有的设置以及所有对监听器代码的处理
     * public ValueAnimator clone()
     */


    private ValueAnimator doRepeatAnim() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 100,5);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //ValueAnimator.ofInt所以转int
                int curValue = (int) animation.getAnimatedValue();
                //,layout（）函数中上下左右点的坐标是以屏幕坐标来标准的。所以在效果图中可以看到，textview的运动轨迹是从屏幕的左上角(0,0)点运行到（400，400）点。
                //左上角坐标和右下角坐标
                tvValueAnimatorClone.layout(curValue, tvValueAnimatorClone.getTop(),curValue + tvValueAnimatorClone.getWidth(),tvValueAnimatorClone.getTop()+tvValueAnimatorClone.getHeight());
            }
        });
        animator.setDuration(1000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        return animator;
    }


}
