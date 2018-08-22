package com.ljh.foodclub.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Description:
 * Date on 2018/6/26
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class SpUtils {

    /**
     * 获取字符串
     *
     * @param context 上下文
     * @param key     字符串的键
     * @return 得到的字符串
     */
    public static String getString(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences("SpUtil", Context.MODE_PRIVATE);
        return preferences.getString(key, "");
    }

    /**
     * 存入字符串
     *
     * @param context 上下文
     * @param key     字符串的键
     * @param value   字符串的值
     */
    public static void putString(Context context, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences("SpUtil", Context.MODE_PRIVATE);
        //存入数据
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
}
