package com.ljh.foodclub.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ljh.foodclub.R;
import com.ljh.foodclub.activity.SettingsActivity;
import com.ljh.foodclub.base.BaseFragment;
import com.ljh.foodclub.base.BaseWebActivity;
import com.ljh.foodclub.base.ImgLoader;
import com.ljh.foodclub.views.dialog.ShareDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:
 * Date on 2018/6/20
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class MineFragment extends BaseFragment {
    @BindView(R.id.iv_top)
    ImageView ivTop;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.rl_settings)
    RelativeLayout rlSettings;
    @BindView(R.id.rl_share)
    RelativeLayout rlShare;
    @BindView(R.id.rl_about_us)
    RelativeLayout rlAboutUs;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_mine;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView(View view) {
        ImgLoader.loadHeadImg(getContext(), "http://upload.mnw.cn/2017/0814/1502698443378.jpg", ivHead);
    }

    @Override
    protected void initListeners() {

    }

    @OnClick({R.id.rl_settings,R.id.rl_share,R.id.rl_about_us})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_about_us:
                Intent intent =new Intent();
                intent.putExtra("url","https://www.baidu.com");
                intent.putExtra("title","百度");
                gotoActivity(BaseWebActivity.class,intent);
                break;
            case R.id.rl_settings:
                gotoActivity(SettingsActivity.class);
                break;
            case R.id.rl_share:
                ShareDialog shareDialog = new ShareDialog(getContext());
                shareDialog.show();
                break;
        }
    }
}