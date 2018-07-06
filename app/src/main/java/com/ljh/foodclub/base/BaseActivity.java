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

        //设置activity为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //把activity入栈
        MyActivityManager.getInstance().add(this);
        //设置布局
        setContentView(getLayoutId());
        //初始化ButterKnife
        ButterKnife.bind(this);

        dealIntentData();

        initView();

        initListeners();

        loadData();
    }

    //获取layout
    protected abstract int getLayoutId();
    //初始化控件
    protected abstract void initView();
    //初始化listener
    protected abstract void initListeners();
    //加载数据
    protected abstract void loadData();
    //用于处理Intent数据,因为非必须使用，所以用的时候重写即可
    protected void dealIntentData(){
    }

    /**
     * 新建一个activity打开
     *
     * @param cls
     */
    public void gotoActivity(Activity activity, Class<?> cls) {
        Intent intent;
        intent = new Intent(this, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_enter_in, R.anim.activity_enter_out);
    }

    /**
     * 返回
     */
    public void back() {
        finish();
        this.overridePendingTransition(R.anim.activity_exit_in, R.anim.activity_exit_out);
    }

    /**
     * 重写系统返回键
     */
    @Override
    public void onBackPressed() {
        finish();
//        this.overridePendingTransition(R.anim.activity_exit_in, R.anim.activity_exit_out);
    }
}
