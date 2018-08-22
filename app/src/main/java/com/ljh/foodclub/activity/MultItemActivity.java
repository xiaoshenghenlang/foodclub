package com.ljh.foodclub.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ljh.foodclub.R;
import com.ljh.foodclub.adapter.GiftRankAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Date on 2018/8/7
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class MultItemActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView mTextView;
    private FrameLayout mFLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multitem);
        List<String> list = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        mTextView = (TextView) findViewById(R.id.tv_info);
        mFLayout = (FrameLayout) findViewById(R.id.fl_layout);

        for (int i = 0; i < 20; i++) {
            list.add(i,"123");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new GiftRankAdapter(this,R.layout.rv_item_giftrank,list));
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                float percent = Float.valueOf(Math.abs(verticalOffset)) / Float.valueOf(appBarLayout.getTotalScrollRange());

                //第一种
                int toolbarHeight = appBarLayout.getTotalScrollRange();

                int dy = Math.abs(verticalOffset);

                if (dy <= toolbarHeight) {
                    float scale = (float) dy / toolbarHeight;
                    float alpha = scale * 255;
                    mFLayout.setBackgroundColor(Color.argb((int) alpha, 255, 255, 255));

                    mTextView.setText("setBackgroundColor(Color.argb((int) "+(int) alpha+", 255, 255, 255))\n"+"mFLayout.setAlpha("+percent+")");
                }

                //第二种

                // mFLayout.setAlpha(percent);
            }
        });
    }
}
