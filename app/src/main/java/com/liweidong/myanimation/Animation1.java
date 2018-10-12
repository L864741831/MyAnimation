package com.liweidong.myanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
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

public class Animation1 extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_alpha_anim)
    Button btnAlphaAnim;
    @BindView(R.id.btn_scale_anim)
    Button btnScaleAnim;
    @BindView(R.id.btn_rotate_anim)
    Button btnRotateAnim;
    @BindView(R.id.btn_translate_anim)
    Button btnTranslateAnim;

    @BindView(R.id.btn_set_anim)
    Button btnSetAnim;

    @BindView(R.id.tv)
    TextView tv;

    Animation alphaAnimation;
    Animation scaleAnimation;
    Animation rotateAnimation;
    Animation translateAnimation;
    Animation setAnimation;

    Animation code_alphaAnimation;
    Animation code_scaleAnimation;
    Animation code_rotateAnimation;
    Animation code_translateAnimation;
    AnimationSet code_setAnimation;

    @BindView(R.id.btn_alpha_anim_code)
    Button btnAlphaAnimCode;
    @BindView(R.id.btn_scale_anim_code)
    Button btnScaleAnimCode;
    @BindView(R.id.btn_rotate_anim_code)
    Button btnRotateAnimCode;
    @BindView(R.id.btn_translate_anim_code)
    Button btnTranslateAnimCode;

    @BindView(R.id.btn_set_anim_code)
    Button btnSetAnimCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation1);

        //绑定初始化ButterKnife（一定要在setContentView之后）
        ButterKnife.bind(this);

        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
        setAnimation = AnimationUtils.loadAnimation(this, R.anim.set_anim);



        code_alphaAnimation = new AlphaAnimation(1.0f,0.1f);
        code_alphaAnimation.setDuration(3000);
        code_alphaAnimation.setFillBefore(true);

        /*
        pivotXType和pivotYType的选择，同样有三个取值：Animation.ABSOLUTE、Animation.RELATIVE_TO_SELF和Animation.RELATIVE_TO_PARENT

        绝对，相对于自身，相对于父View
         */
        code_scaleAnimation = new ScaleAnimation(0.0f,1.4f,0.0f,1.4f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        code_scaleAnimation.setDuration(700);


        code_rotateAnimation = new RotateAnimation(0, -650, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        code_rotateAnimation.setDuration(3000);
        code_rotateAnimation.setFillAfter(true);

        code_translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, -80,
                Animation.ABSOLUTE, 0, Animation.ABSOLUTE, -80);
        code_translateAnimation.setDuration(2000);
        code_translateAnimation.setFillBefore(true);


        AlphaAnimation alphaAnim = new AlphaAnimation(1.0f,0.1f);
        ScaleAnimation scaleAnim = new ScaleAnimation(0.0f,1.4f,0.0f,1.4f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        RotateAnimation rotateAnim = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        code_setAnimation=new AnimationSet(true);
        code_setAnimation.addAnimation(alphaAnim);
        code_setAnimation.addAnimation(scaleAnim);
        code_setAnimation.addAnimation(rotateAnim);

        code_setAnimation.setInterpolator(new BounceInterpolator());
        code_setAnimation.setDuration(3000);
        code_setAnimation.setFillAfter(true);;
    }

    @OnClick({R.id.btn_alpha_anim, R.id.btn_scale_anim, R.id.btn_rotate_anim, R.id.btn_translate_anim, R.id.btn_set_anim,
            R.id.btn_alpha_anim_code, R.id.btn_scale_anim_code, R.id.btn_rotate_anim_code, R.id.btn_translate_anim_code, R.id.btn_set_anim_code
    })

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alpha_anim:
                tv.startAnimation(alphaAnimation);
                break;
            case R.id.btn_scale_anim:
                tv.startAnimation(scaleAnimation);
                break;
            case R.id.btn_rotate_anim:
                tv.startAnimation(rotateAnimation);
                break;
            case R.id.btn_translate_anim:
                tv.startAnimation(translateAnimation);
                break;
            case R.id.btn_set_anim:
                //tv.setVisibility(View.VISIBLE);
                tv.startAnimation(setAnimation);
                break;

            case R.id.btn_alpha_anim_code:
                tv.startAnimation(code_alphaAnimation);
                break;
            case R.id.btn_scale_anim_code:
                tv.startAnimation(code_scaleAnimation);
                break;
            case R.id.btn_rotate_anim_code:
                tv.startAnimation(code_rotateAnimation);
                break;
            case R.id.btn_translate_anim_code:
                tv.startAnimation(code_translateAnimation);
                break;
            case R.id.btn_set_anim_code:
                //tv.setVisibility(View.VISIBLE);
                tv.startAnimation(code_setAnimation);
                break;
        }
    }
}
