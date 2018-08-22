package com.ljh.foodclub.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ljh.foodclub.MainActivity;
import com.ljh.foodclub.R;
import com.ljh.foodclub.adapter.GuideViewpagerAdapter;
import com.ljh.foodclub.base.BaseActivity;
import com.ljh.foodclub.utils.SpUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:
 * Date on 2018/6/26
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class GuideActivity extends BaseActivity {

    @BindView(R.id.banner)
    ViewPager banner;
    @BindView(R.id.iv_circle_first)
    ImageView ivCircleFirst;
    @BindView(R.id.iv_circle_second)
    ImageView ivCircleSecond;
    @BindView(R.id.iv_circle_third)
    ImageView ivCircleThird;
    @BindView(R.id.tv_enter)
    TextView tvEnter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initView() {
        //如果不为1说明第一次打开，则展示引导页
        if (!"1".equals(SpUtils.getString(this, "firstOpen"))) {
            SpUtils.putString(this, "firstOpen", "1");
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        banner.setAdapter(new GuideViewpagerAdapter(this));
        ivCircleFirst.setImageResource(R.drawable.shape_oval_white);

        banner.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ivCircleFirst.setImageResource(R.drawable.shape_oval_gray);
                ivCircleSecond.setImageResource(R.drawable.shape_oval_gray);
                ivCircleThird.setImageResource(R.drawable.shape_oval_gray);
                tvEnter.setVisibility(View.GONE);
                switch (position) {
                    case 0:
                        ivCircleFirst.setImageResource(R.drawable.shape_oval_white);
                        break;
                    case 1:
                        ivCircleSecond.setImageResource(R.drawable.shape_oval_white);
                        break;
                    case 2:
                        ivCircleThird.setImageResource(R.drawable.shape_oval_white);
                        tvEnter.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void loadData() {

    }

    @OnClick(R.id.tv_enter)
    public void onViewClicked() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
