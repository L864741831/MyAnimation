package com.liweidong.myanimation;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author:李炜东
 * Date:2018/9/13.
 * WX:17337162963
 * Email:18037891572@163.com
 */

public class Animation3 extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_BounceInterpolator)
    Button btnBounceInterpolator;
    @BindView(R.id.tv_BounceInterpolator)
    TextView tvBounceInterpolator;

    @BindView(R.id.btn_MyInterploator)
    Button btnMyInterploator;
    @BindView(R.id.tv_MyInterploator)
    TextView tvMyInterploator;

    @BindView(R.id.btn_MyEvaluator)
    Button btnMyEvaluator;
    @BindView(R.id.tv_MyEvaluator)
    TextView tvMyEvaluator;

    @BindView(R.id.btn_reverse_evaluator)
    Button btnReverseEvaluator;
    @BindView(R.id.tv_reverse_evaluator)
    TextView tvReverseEvaluator;

    @BindView(R.id.btn_color)
    Button btnColor;
    @BindView(R.id.tv_color)
    TextView tvColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation3);

        //绑定初始化ButterKnife（一定要在setContentView之后）
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_BounceInterpolator, R.id.btn_MyInterploator, R.id.btn_MyEvaluator, R.id.btn_reverse_evaluator,R.id.btn_color})
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_BounceInterpolator:
                ValueAnimator animator = ValueAnimator.ofInt(0, 600);

                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int) animation.getAnimatedValue();
                        tvBounceInterpolator.layout(tvBounceInterpolator.getLeft(), curValue, tvBounceInterpolator.getRight(), curValue + tvBounceInterpolator.getHeight());
                    }
                });
                animator.setDuration(1000);
                animator.setInterpolator(new BounceInterpolator());
                animator.start();
                break;

            case R.id.btn_MyInterploator:
                ValueAnimator my_interploator = ValueAnimator.ofInt(0, 600);

                my_interploator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        //当前的值 = 0 + （600 - 0）* 显示进度
                        int curValue = (int) animation.getAnimatedValue();
                        tvMyInterploator.layout(tvMyInterploator.getLeft(), curValue, tvMyInterploator.getRight(), curValue + tvMyInterploator.getHeight());
                    }
                });
                my_interploator.setDuration(1000);
                my_interploator.setInterpolator(new MyInterploator());
                my_interploator.start();
                break;

            case R.id.btn_MyEvaluator:
                ValueAnimator my_evaluator = ValueAnimator.ofInt(0, 400);

                my_evaluator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int) animation.getAnimatedValue();
                        tvMyEvaluator.layout(tvMyEvaluator.getLeft(), curValue, tvMyEvaluator.getRight(), curValue + tvMyEvaluator.getHeight());
                    }
                });
                my_evaluator.setDuration(1000);
                my_evaluator.setEvaluator(new MyEvaluator());
                my_evaluator.start();
                break;

            case R.id.btn_reverse_evaluator:

                ValueAnimator my_reverse_evaluator = ValueAnimator.ofInt(0, 400);

                my_reverse_evaluator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int) animation.getAnimatedValue();
                        tvReverseEvaluator.layout(tvReverseEvaluator.getLeft(), curValue, tvReverseEvaluator.getRight(), curValue + tvReverseEvaluator.getHeight());
                    }
                });
                my_reverse_evaluator.setDuration(1000);
                my_reverse_evaluator.setEvaluator(new ReverseEvaluator());
                my_reverse_evaluator.start();

                break;

            case R.id.btn_color:

                ValueAnimator animator_color = ValueAnimator.ofInt(0xffffff00,0xff0000ff);
                animator_color.setEvaluator(new ArgbEvaluator());
                animator_color.setDuration(3000);

                animator_color.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int)animation.getAnimatedValue();
                        tvColor.setBackgroundColor(curValue);

                    }
                });

                animator_color.start();

                break;

        }
    }


}
