package com.ljh.foodclub.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.ljh.foodclub.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Description:
 * Date on 2018/6/20
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        initView(view);

        initListeners();

        loadData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 通过Class跳转界面
     **/
    protected void gotoActivity(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.activity_enter_in, R.anim.activity_enter_out);
    }

    /**
     * 通过Class跳转界面
     **/
    protected void gotoActivity(Class<?> cls,Intent intent) {
        intent.setClass(getActivity(), cls);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.activity_enter_in, R.anim.activity_enter_out);
    }

    // 直接读取系统里状态栏高度的值，但是无法判断状态栏是否显示
    public int getStatusBarHeight(){
        int height = 0;
        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            height = getResources().getDimensionPixelSize(resourceId);
        }
        return height;
    }

    protected void initTitle(RelativeLayout relativeLayout) {
        //设置title与距离为statusBar的高度
        int statusBarHeight = getStatusBarHeight();
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        lp.setMargins(0, statusBarHeight, 0, 0);
        relativeLayout.setLayoutParams(lp);
    }

    protected abstract int getLayoutId();

    protected abstract void loadData();

    protected abstract void initView(View view);

    protected abstract void initListeners();
}
