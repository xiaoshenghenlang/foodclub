package com.ljh.foodclub.base;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.ljh.foodclub.R;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Description:
 * Date on 2018/6/26
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class ImgLoader {
    /**
     * 加载为普通图片
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadImg(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.load_failed)
                .priority(Priority.LOW)
                .into(imageView);
    }

    /**
     * 加载本地图片
     * @param context
     * @param id
     * @param imageView
     */
    public static void loadLocalImg(Context context, int id, ImageView imageView){
        Glide.with(context)
                .load(id)
                .placeholder(R.drawable.loading)
                .error(R.drawable.load_failed)
                .priority(Priority.HIGH)
                .into(imageView);
    }

    /**
     * 加载为圆形图片
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadCircleImg(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.load_failed)
                .priority(Priority.HIGH)
                .bitmapTransform(new CropCircleTransformation(context))
                .into(imageView);
    }

    /**
     * 加载为圆形头像图片
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadHeadImg(Context context, String url, ImageView imageView){
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.shape_oval_white)
                .error(R.drawable.load_failed)
                .priority(Priority.HIGH)
                .bitmapTransform(new CropCircleTransformation(context))
                .into(imageView);
    }

    /**
     * 加载为高斯模糊图片
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadDimImg(Context context, String url, ImageView imageView,int dimLevel){
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.load_failed)
                .priority(Priority.HIGH)
                .bitmapTransform(new BlurTransformation(context, dimLevel))
                .into(imageView);
    }
}
