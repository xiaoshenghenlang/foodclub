package com.ljh.foodclub.appconfig;

import android.app.Application;
import android.content.Context;

import com.lzy.okgo.OkGo;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Description:
 * Date on 2018/6/12
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class App extends Application {
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initOkGo();
    }

    /**
     * 实例化okgo
     */
    private void initOkGo() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.put("User-Agent", "ANDROID");
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.proxy(Proxy.NO_PROXY);
        builder.readTimeout(10, TimeUnit.SECONDS);      //全局的读取超时时间
        builder.writeTimeout(10, TimeUnit.SECONDS);     //全局的写入超时时间
        builder.connectTimeout(10, TimeUnit.SECONDS);   //全局的连接超时时间
        OkGo.getInstance().init(this);
//                .addCommonHeaders(headers)
    }
}
