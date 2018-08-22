package com.ljh.foodclub.fragment;

import android.annotation.SuppressLint;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ljh.foodclub.R;
import com.ljh.foodclub.adapter.LogAdapter;
import com.ljh.foodclub.base.BaseFragment;
import com.ljh.foodclub.views.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.transformer.CubeInTransformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Description:
 * Date on 2018/6/20
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.v_first_line)
    View vFirstLine;
    @BindView(R.id.tv_first_title)
    TextView tvFirstTitle;
    @BindView(R.id.scrollview)
    NestedScrollView scrollView;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.appbar)
    AppBarLayout mAppBarLayout;
    private int height;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_home;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView(View view) {
//        initTitle(rlTop);
//        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        List<String> images = new ArrayList<>();
        images.add(0, "http://upload.mnw.cn/2017/0814/1502698443378.jpg");
        images.add(1, "http://upload.mnw.cn/2017/0814/1502698443378.jpg");
        images.add(2, "http://upload.mnw.cn/2017/0814/1502698443378.jpg");
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置动画
        banner.setPageTransformer(false, new CubeInTransformer());
        //设置图片集合
        banner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        banner.start();

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i, "123");
        }
        //NestScrollView嵌套recycleview处理卡顿
        rv.setHasFixedSize(true);
        rv.setNestedScrollingEnabled(false);
        rv.setAdapter(new LogAdapter(getActivity(), R.layout.rv_item_log, list));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        banner.measure(0, 0);
        height = banner.getMeasuredHeight();

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @SuppressLint("Range")
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                //第一种
                int toolbarHeight = appBarLayout.getTotalScrollRange();

                int dy = Math.abs(verticalOffset);

                if (dy <= toolbarHeight) {
                    float scale = (float) dy / toolbarHeight;
                    float alpha = scale * 255;
                    if (alpha >= 255) {
                        rlTop.getBackground().setAlpha(255);
//                        rlTop.setBackgroundColor(Color.argb(255, 255, 255, 0));
                    } else if(alpha<255){
                        rlTop.getBackground().setAlpha((int) alpha);
//                        rlTop.setBackgroundColor(Color.argb((int) alpha, 255, 255, 0));
                    }
                }

            }
        });
    }

    @Override
    protected void initListeners() {
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        ViewTreeObserver vto = tvFirstTitle.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                tvFirstTitle.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                tvFirstTitle.getHeight();
                tvFirstTitle.getWidth();
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) vFirstLine.getLayoutParams();
                //获取当前控件的布局对象
                params.height = tvFirstTitle.getHeight() * 3 / 4;//设置当前控件布局的高度
                vFirstLine.setLayoutParams(params);//将设置好的布局参数应用到控件中
            }
        });
    }


    //如果你需要考虑更好的体验，可以这么操作
    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }

}
