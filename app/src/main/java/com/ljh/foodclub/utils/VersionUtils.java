package com.ljh.foodclub.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * Description:系统版本判断
 * Date on 2018/4/18
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class VersionUtils {
    //判断是否大于安卓7.0
    public static Uri isSeven(Context context,File file, Intent intent) {
        Uri uri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //大于7.0，应使用该路径
            uri = FileProvider.getUriForFile(context, "com.ljh.foodclub.fileprovider", file);
            // 给目标应用一个临时授权
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION|Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        } else {
            //小于7.0
            uri = Uri.fromFile(file);
        }
        return uri;
    }
}
