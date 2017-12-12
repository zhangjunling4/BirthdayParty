package com.seek.birthdayparty.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.seek.birthdayparty.R;
import com.seek.birthdayparty.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.tv_skip)
    TextView tvSkip;

    private CountDownTimer timer;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_splash;
    }


    @Override
    protected void initViewsAndEvents() {
        timer = new CountDownTimer(3500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvSkip.setText(String.format(getResources().getString(R.string.skip), (int)(millisUntilFinished / 1000 + 0.1)));
            }

            @Override
            public void onFinish() {
                tvSkip.setText(String.format(getString(R.string.skip), 0));
                startActivity(new Intent(SplashActivity.this, WelActivity.class));
                finish();
            }
        };

        timer.start();
    }

    @OnClick(R.id.tv_skip)
    public void skip(){
        if (timer != null){
            timer.cancel();
        }
        startActivity(new Intent(SplashActivity.this, WelActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (timer != null){
            timer.cancel();
        }
    }
}
