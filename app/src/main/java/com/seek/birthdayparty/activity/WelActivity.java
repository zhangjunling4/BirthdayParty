package com.seek.birthdayparty.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.seek.birthdayparty.R;
import com.seek.birthdayparty.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelActivity extends BaseActivity {

    @BindView(R.id.qq_login)
    ImageView qqLogin;
    @BindView(R.id.wechat_login)
    ImageView weChatLogin;

    @Override
    protected void initViewsAndEvents() {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_wel;
    }

    @OnClick(R.id.qq_login)
    public void qqLogin(){
//        Toast.makeText(WelActivity.this, "QQ登录", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(WelActivity.this, MainActivity.class));
        finish();
    }

    @OnClick(R.id.wechat_login)
    public void weChatLogin(){
        Toast.makeText(WelActivity.this, "微信登录", Toast.LENGTH_SHORT).show();
    }
}
