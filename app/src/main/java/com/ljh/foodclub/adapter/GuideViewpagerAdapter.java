package com.ljh.foodclub.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.ljh.foodclub.R;
import com.ljh.foodclub.base.ImgLoader;

/**
 * Description:
 * Date on 2018/6/26
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class GuideViewpagerAdapter extends PagerAdapter {
    private Context context;

    public GuideViewpagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        switch (position) {
            case 0:
                ImgLoader.loadLocalImg(context,R.drawable.sights,imageView);
//                imageView.setImageResource(R.drawable.sights);
                break;
            case 1:
                ImgLoader.loadLocalImg(context,R.drawable.sights,imageView);
//                imageView.setImageResource(R.drawable.sights);
                break;
            case 2:
                ImgLoader.loadLocalImg(context,R.drawable.sights,imageView);
//                imageView.setImageResource(R.drawable.sights);
                break;
        }
        container.addView(imageView);
        return imageView;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    }
}
