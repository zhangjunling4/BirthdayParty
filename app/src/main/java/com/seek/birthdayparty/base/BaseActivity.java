package com.seek.birthdayparty.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import com.seek.birthdayparty.R;
import com.seek.birthdayparty.utils.StatusBarCompat;

import butterknife.ButterKnife;

/**
 * Created by admin on 2017/12/8.
 */

public abstract class BaseActivity extends AppCompatActivity {
    /**
     * Screen information
     */
    protected int mScreenWidth = 0;
    protected int mScreenHeight = 0;
    protected float mScreenDensity = 0.0f;

    protected Context mContext = null;
    private final static String TAG = BaseActivity.class.getSimpleName();

    protected Toolbar mToolbar;
    protected boolean statusBarCompat = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.right_in, R.anim.right_out);//activity打开的动画
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");

        mContext = this;
        BaseAppManager.getInstance().addActivity(this);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        mScreenDensity = displayMetrics.density;
        mScreenHeight = displayMetrics.heightPixels;
        mScreenWidth = displayMetrics.widthPixels;

        if (statusBarCompat) {
            StatusBarCompat.compat(this, ContextCompat.getColor(this, R.color.colorPrimaryDark));
            transparent19and20();
        }

        if (getContentViewLayoutID() != 0) {
            Log.i(TAG, "getContentViewLayoutID()");
            setContentView(getContentViewLayoutID());
        } else {
            throw new IllegalArgumentException("You must return a right contentView layout resource Id");
        }

        initViewsAndEvents();

    }

    protected void transparent19and20() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
                && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    protected abstract void initViewsAndEvents();

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        ButterKnife.bind(this);


    }

    @Override
    public void finish() {
        super.finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * bind layout resource file
     *
     * @return id of layout resource
     */
    protected abstract int getContentViewLayoutID();
}
