package com.ljh.foodclub.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.transition.Transition;
import android.view.View;
import android.widget.ImageView;

import com.ljh.foodclub.R;
import com.ljh.foodclub.base.BaseActivity;
import com.ljh.foodclub.base.ImgLoader;
import com.ljh.foodclub.itf.ImgManager;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Description:
 * Date on 2018/6/21
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class PhotoViewActivity extends BaseActivity {
    @BindView(R.id.photoview)
    PhotoView photoview;
    @BindView(R.id.iv)
    ImageView iv;
    private String imgurl;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_photoview;
    }

    @Override
    protected void initView() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav
                        // bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
        Intent intent = getIntent();
        imgurl = intent.getStringExtra("imgurl");
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void loadData() {
//        Glide.with(this)
//                .load(imgurl)
//                .into(iv);
        ImgLoader.loadImg(this, imgurl, iv, false, new ImgManager() {
            @Override
            public void onSuccess() {
                iv.setVisibility(View.GONE);
                Picasso.with(PhotoViewActivity.this)
                        .load(imgurl)
                        .into(iv);
            }

            @Override
            public void onError() {

            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getEnterTransition().addListener(new Transition.TransitionListener() {

                @Override
                public void onTransitionStart(Transition transition) {

                }

                @Override
                public void onTransitionEnd(Transition transition) {

                }

                @Override
                public void onTransitionCancel(Transition transition) {

                }

                @Override
                public void onTransitionPause(Transition transition) {

                }

                @Override
                public void onTransitionResume(Transition transition) {

                }
            });
        }
        photoview.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onPhotoTap(View view, float x, float y) {
                onBackPressed();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBackPressed() {
        finishAfterTransition();
//        this.overridePendingTransition(R.anim.activity_scale_enter_out, 0);
    }
}
