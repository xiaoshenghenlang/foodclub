package com.ljh.foodclub.activity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flyco.tablayout.SlidingTabLayout;
import com.ljh.foodclub.R;
import com.ljh.foodclub.base.BaseActivity;
import com.ljh.foodclub.base.ImgLoader;
import com.ljh.foodclub.fragment.otherfragment.GiftRankFragment;
import com.ljh.foodclub.fragment.otherfragment.GoodsFragment;
import com.ljh.foodclub.fragment.otherfragment.LogFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:
 * Date on 2018/6/22
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class IdolInfoActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.appbarlayout)
    AppBarLayout appbarlayout;
    @BindView(R.id.tv_name_bottom)
    TextView tv_name_bottom;
    @BindView(R.id.tv_name_top)
    TextView tv_name_top;
    @BindView(R.id.tv_des)
    TextView tvDes;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.collapsingtoolbarlayout)
    CollapsingToolbarLayout collapsingtoolbarlayout;
    private CollapsingToolbarLayoutState state;
    private List<Fragment> mFragments;
    private String[] mTitles;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finishAfterTransition();
    }

    //枚举3中状态
    private enum CollapsingToolbarLayoutState {
        EXPANDED,
        COLLAPSED,
        INTERNEDIATE
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Transition transition = new Slide();//滑动
//        transition.setDuration(600);
//        //2.设置当前Activity进入和退出使用特效
//        getWindow().setEnterTransition(transition);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_idol_info;
    }

    @Override
    protected void initView() {
        mFragments = new ArrayList<>();
        mTitles = new String[]{getString(R.string.message), getString(R.string.ta_product), getString(R.string.gift_rank)};
        mFragments.add(new LogFragment());
        mFragments.add(new GoodsFragment());
        mFragments.add(new GiftRankFragment());

        SlidingTabLayout mStl = (SlidingTabLayout) findViewById(R.id.stl);
        MyPageAdapter mAdapter = new MyPageAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);
        vp.setOffscreenPageLimit(2);
        mStl.setViewPager(vp);
    }

    private class MyPageAdapter extends FragmentPagerAdapter {
        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        }else {
            finish();
        }
    }

    @Override
    protected void initListeners() {
        appbarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @SuppressLint("Range")
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset == 0) {
                    //修改状态标记为展开
                    if (state != CollapsingToolbarLayoutState.EXPANDED) {
                        state = CollapsingToolbarLayoutState.EXPANDED;
                        tv_name_top.setVisibility(View.INVISIBLE);
                        tv_name_bottom.setVisibility(View.VISIBLE);
                        tvDes.setVisibility(View.VISIBLE);
                    }
                } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                    //修改状态标记为折叠
                    if (state != CollapsingToolbarLayoutState.COLLAPSED) {
                        state = CollapsingToolbarLayoutState.COLLAPSED;
                        tv_name_top.setVisibility(View.VISIBLE);
                        tv_name_bottom.setVisibility(View.INVISIBLE);
                        tvDes.setVisibility(View.INVISIBLE);
                    }
                } else {
                    //修改状态标记为中间
                    if (state != CollapsingToolbarLayoutState.INTERNEDIATE) {
                        if (state == CollapsingToolbarLayoutState.COLLAPSED) {
                        }
                        state = CollapsingToolbarLayoutState.INTERNEDIATE;
                    }
                }

//                //第一种
//                int toolbarHeight = appBarLayout.getTotalScrollRange();
//
//                int dy = Math.abs(verticalOffset);
//
//                if (dy <= toolbarHeight) {
//                    float scale = (float) dy / toolbarHeight;
//                    float alpha = scale * 255;
//                    if (alpha >= 255) {
//                        tv_name_top.setAlpha(0);
//                        tv_name_bottom.setAlpha(255);
//                        tvDes.setAlpha(255);
////                        rlTop.setBackgroundColor(Color.argb(255, 255, 255, 0));
//                    } else if(alpha<255){
//                        tv_name_top.setAlpha(255-alpha);
//                        tv_name_bottom.setAlpha(alpha);
//                        tvDes.setAlpha(alpha);
////                        rlTop.setBackgroundColor(Color.argb((int) alpha, 255, 255, 0));
//                    }
//                }
            }
        });

    }


    @Override
    protected void loadData() {
        ImgLoader.loadHeadImg(this, "http://upload.mnw.cn/2017/0814/1502698443378.jpg", ivHead);
        ImgLoader.loadImg(this, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg", ivBg,false);
    }

}
