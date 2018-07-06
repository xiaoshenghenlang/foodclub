package com.ljh.foodclub.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.ljh.foodclub.R;
import com.ljh.foodclub.itf.ImgManager;
import com.ljh.foodclub.views.dialog.LoadDialog;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Description:
 * Date on 2018/6/26
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class ImgLoader {

    private static LoadDialog loadDialog;

    /**
     * 加载为普通图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadImg(final Context context, final String url, final ImageView imageView, final boolean isVertical, final ImgManager imgManager) {
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.pic_default_vertical)
                .error(R.drawable.load_failed)
                .priority(Priority.LOW)
                .into(new GlideDrawableImageViewTarget(imageView) {
                    @Override
                    public void onLoadFailed(Exception e, Drawable errorDrawable) {
                        super.onLoadFailed(e, errorDrawable);
                        imgManager.onError();
//                        if (isVertical) {
//                            Glide.with(context)
//                                    .load(R.drawable.pic_default_vertical)
//                                    .into(imageView);
//                        } else {
//                            Glide.with(context)
//                                    .load(R.drawable.pic_default)
//                                    .into(imageView);
//                        }
                    }

                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                        super.onResourceReady(resource, animation);
                        loadDialog.dismiss();
                    }

                    @Override
                    public void onLoadStarted(Drawable placeholder) {
                        loadDialog = new LoadDialog(context);
                        loadDialog.show();
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                    }
                });
    }

    /**
     * 加载为普通图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadImg(final Context context, final String url, final ImageView imageView, final boolean isVertical) {
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.load_failed)
                .priority(Priority.LOW)
                .into(imageView);
    }

    /**
     * 加载本地图片
     *
     * @param context
     * @param id
     * @param imageView
     */
    public static void loadLocalImg(Context context, int id, ImageView imageView) {
        Glide.with(context)
                .load(id)
                .placeholder(R.drawable.loading)
                .error(R.drawable.load_failed)
                .priority(Priority.HIGH)
                .into(imageView);
    }

    /**
     * 加载为圆形图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadCircleImg(Context context, String url, ImageView imageView) {
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
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadHeadImg(Context context, String url, ImageView imageView) {
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
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadDimImg(Context context, String url, ImageView imageView, int dimLevel) {
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.load_failed)
                .priority(Priority.HIGH)
                .bitmapTransform(new BlurTransformation(context, dimLevel))
                .into(imageView);
    }

    /**
     * 加载为圆角图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadCircleCornerImg(Context context, String url, ImageView imageView, int radius) {
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.load_failed)
                .priority(Priority.HIGH)
                .bitmapTransform(new RoundedCornersTransformation(context, radius, 0, RoundedCornersTransformation.CornerType.ALL))
                .into(imageView);
    }

}
