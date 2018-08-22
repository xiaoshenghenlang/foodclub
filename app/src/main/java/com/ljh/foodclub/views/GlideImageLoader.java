package com.ljh.foodclub.views;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.ljh.foodclub.base.ImgLoader;
import com.youth.banner.loader.ImageLoaderInterface;

/**
 * Description:
 * Date on 2018/7/12
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class GlideImageLoader implements ImageLoaderInterface {
    @Override
    public void displayImage(Context context, Object path, View imageView) {
        ImgLoader.loadImg(context,(String)path,(ImageView) imageView,false);
    }

    @Override
    public View createImageView(Context context) {
        return null;
    }
}
