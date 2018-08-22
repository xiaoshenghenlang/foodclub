package com.ljh.foodclub.activity;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ljh.foodclub.R;
import com.ljh.foodclub.base.BaseActivity;
import com.ljh.foodclub.base.ImgLoader;

import butterknife.BindView;
import uk.co.senab.photoview.PhotoView;

/**
 * Description:
 * Date on 2018/6/28
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class ImgDetailActivity extends BaseActivity {
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tv_position)
    TextView tvPosition;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_imgdetail;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);
        vp.setAdapter(new ImgDetailViewpagerAdapter());
        vp.setCurrentItem(position);
        tvPosition.setText((position+1)+"/"+"2");
    }

    @Override
    protected void initListeners() {
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                tvPosition.setText((position+1)+"/"+"2");
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void loadData() {

    }

    private class ImgDetailViewpagerAdapter extends PagerAdapter {
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            PhotoView photoView = new PhotoView(ImgDetailActivity.this);
            ImgLoader.loadLocalImg(ImgDetailActivity.this,R.drawable.sights,photoView);
            container.addView(photoView);
            return photoView;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
}
