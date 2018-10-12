package com.liweidong.myanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.tv_one)
    TextView tvOne;
    @BindView(R.id.tv_two)
    TextView tvTwo;
    @BindView(R.id.tv_there)
    TextView tvThere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定初始化ButterKnife（一定要在setContentView之后）
        ButterKnife.bind(this);
    }


    @OnClick({R.id.tv_one, R.id.tv_two,R.id.tv_there})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_one:
                startActivity(new Intent(this, Animation1.class));
                break;
            case R.id.tv_two:
                startActivity(new Intent(this, Animation2.class));
                break;
            case R.id.tv_there:
                startActivity(new Intent(this, Animation3.class));
                break;
        }
    }
}
