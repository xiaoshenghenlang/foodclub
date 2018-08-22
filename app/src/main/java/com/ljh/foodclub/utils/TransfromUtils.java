package com.ljh.foodclub.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Description:
 * Date on 2018/4/17
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class TransfromUtils {

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof NinePatchDrawable) {
            Bitmap bitmap = Bitmap
                    .createBitmap(
                            drawable.getIntrinsicWidth(),
                            drawable.getIntrinsicHeight(),
                            drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                                    : Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                    drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return bitmap;
        } else {
            return null;
        }
    }

    public static byte[] Bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }

    public static File drawableToFile(Context mContext, int drawableId,String filepath, String fileName){
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), drawableId);

        // 首先保存图片路径
        File appDir = new File(Environment.getExternalStorageDirectory(),
                filepath);
        if (!appDir.exists()) {
            appDir.mkdir();
        }

        //当前时间来命名图片
        String fName = fileName + ".jpg";
        File file = new File(appDir, fName);

        try {
            FileOutputStream fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /**
     * bitmap转file
     * @param bitmap
     * @param imgName
     * @return
     */
    public static File saveBitmapToFile(Bitmap bitmap,String path,String imgName){
        File file = new File(Environment.getExternalStorageDirectory(),
                path);
        if (!file.exists()) {
            file.mkdir();
        }
        //当前时间来命名图片
        String fileName = imgName + ".jpg";
        File appDir = new File(file, fileName);
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(appDir));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appDir;
    }

    /**
     * 保存图片到本地
     *
     * @param context
     * @param bmp
     */
    public static String saveImage(Context context, Bitmap bmp,String path,String fileName) {
        if (bmp == null) {
            return null;
        }
        // 首先保存图片路径
        File appDir = new File(Environment.getExternalStorageDirectory(),
                path);
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        File[] files = appDir.listFiles();
        for (File f : files) {
            f.delete();
        }
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            return file.getAbsolutePath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
