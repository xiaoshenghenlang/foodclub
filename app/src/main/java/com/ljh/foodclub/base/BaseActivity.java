package com.ljh.foodclub.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ljh.foodclub.R;

import butterknife.ButterKnife;

/**
 * Description:
 * Date on 2018/6/12
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        MyActivityManager.getInstance().add(this);
        setContentView(getLayoutId());
        //初始化ButterKnife
        ButterKnife.bind(this);

        initView();

        initListeners();

        loadData();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void initListeners();

    protected abstract void loadData();

    /**
     * 新建一个activity打开
     *
     * @param cls
     */
    public void gotoActivity(Activity activity, Class<?> cls) {
        Intent intent;
        intent = new Intent(this, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.enter_in, R.anim.enter_out);
    }

    /**
     * 返回
     */
    public void back() {
        finish();
        this.overridePendingTransition(R.anim.exit_in, R.anim.exit_out);
    }

    /**
     * 重写系统返回键
     */
    @Override
    public void onBackPressed() {
        finish();
        this.overridePendingTransition(R.anim.exit_in, R.anim.exit_out);

    }
}
