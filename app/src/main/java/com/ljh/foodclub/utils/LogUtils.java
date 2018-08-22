package com.ljh.foodclub.utils;

import android.app.Activity;
import android.util.Log;

import com.ljh.foodclub.BuildConfig;

/**
 * @Auther lijiahong
 * @Create Date 2018/5/11 13:50
 */

public class LogUtils {

    private static String TAG="";
    private LogUtils(){}

    public static boolean isDebuggable() {
        return BuildConfig.DEBUG;
    }

    public static void v(Activity activity,String content){
        if (!isDebuggable())
            return;
        TAG = activity.getClass().getSimpleName();
        Log.v(TAG, content);
    }

    public static void d(Activity activity,String content){
        if (!isDebuggable())
            return;
        TAG = activity.getClass().getSimpleName();
        Log.d(TAG, content);
    }

    public static void i(Activity activity,String content){
        if (!isDebuggable())
            return;
        TAG = activity.getClass().getSimpleName();
        Log.i(TAG, content);
    }

    public static void w(Activity activity,String content){
        if (!isDebuggable())
            return;
        TAG = activity.getClass().getSimpleName();
        Log.w(TAG, content);
    }

    public static void e(Activity activity,String content){
        if (!isDebuggable())
            return;
        TAG = activity.getClass().getSimpleName();
        Log.e(TAG, content);
    }

    public static void getDataSuccess(String content){
        if (!isDebuggable())
            return;
        Log.e("getDataSuccess", content);
    }

    public static void getDataError(String content){
        if (!isDebuggable())
            return;
        Log.e("getDataError", content);
    }
}
