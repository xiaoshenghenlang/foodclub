package com.ljh.foodclub.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

/**
 * Description:剪贴板管理器工具
 * Date on 2018/5/31
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class ClipboardManagerUtils {
    /**
     * 保存至剪贴板
     * @param context
     * @param s
     */
    public static void save(Context context,String s){
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        // 创建普通字符型ClipData
        ClipData mClipData = ClipData.newPlainText("Label", s);
        // 将ClipData内容放到系统剪贴板里。
        cm.setPrimaryClip(mClipData);
        Toast.makeText(context, "已复制", Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取剪贴板的内容
     * @param context
     * @return
     */
    public static String copy(Context context){
        //获取剪贴板管理器
        ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        String s = cm.getText().toString();
        return s;
    }
}
