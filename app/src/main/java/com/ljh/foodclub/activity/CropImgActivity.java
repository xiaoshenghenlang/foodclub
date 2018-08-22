package com.ljh.foodclub.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ljh.foodclub.R;
import com.ljh.foodclub.base.ImgLoader;
import com.ljh.foodclub.base.PicassoImageLoader;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;

import java.util.ArrayList;

/**
 * Description:
 * Date on 2018/7/16
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class CropImgActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cropimg);
        Button bt1 = (Button) findViewById(R.id.btn1);
        iv = (ImageView) findViewById(R.id.iv);

        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new PicassoImageLoader());//设置图片加载器
        imagePicker.setShowCamera(true);//显示拍照按钮
        imagePicker.setMultiMode(false);//图片选着模式，单选/多选
        imagePicker.setSaveRectangle(true);//是否按矩形区域保存
        imagePicker.setCrop(true);//允许裁剪（单选才有效）
        Integer radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 140, getResources().getDisplayMetrics());
        imagePicker.setFocusWidth(radius * 2);
        imagePicker.setFocusHeight(radius * 2);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkpermission();
            }
        });
    }

    private void checkpermission() {
        //判断应用当前是否有如下权限,如果没有则向手机请求权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //请求权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
        } else {
            startCrop(true);
        }
    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //如果请求状态码保持一致
        if (requestCode == 1) {
            //获取请求结果
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCrop(false);
            } else {
                checkpermission();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void startCrop(boolean a) {
        if (a) {
            Intent intent = new Intent(this, ImageGridActivity.class);
            intent.putExtra(ImageGridActivity.EXTRAS_TAKE_PICKERS, true); // 是否是直接打开相机
            startActivityForResult(intent, 123);
        } else {
            Intent intent = new Intent(this, ImageGridActivity.class);
            startActivityForResult(intent, 123);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == 123) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                String imageItem = images.get(0).path;
                ImgLoader.loadImg(this, imageItem, iv, false);
            } else {
                Toast.makeText(this, "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
