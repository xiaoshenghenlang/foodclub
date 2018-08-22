package com.ljh.foodclub.protocol;

import android.text.TextUtils;

import com.ljh.foodclub.appconfig.App;
import com.ljh.foodclub.appconfig.AppConfig;
import com.ljh.foodclub.appconfig.OnHttpListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.HttpParams;
import com.lzy.okgo.model.Response;

import java.util.Map;
import java.util.TreeMap;

/**
 * Description:
 * Date on 2018/7/12
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public abstract class BaseProtocol<T> {

    public void getDataFromNet(String url, TreeMap<String, Object> map, final OnHttpListener onHttpListener) {
        HttpParams params = new HttpParams();
        if (null != map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                params.put(key, value + "");
            }
        }
        OkGo.<String>get(AppConfig.getHost() + url)
                .tag(App.context)
                .params(params)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        if (!TextUtils.isEmpty(response.body())) {
                            onHttpListener.success(response.body());
                        } else {
                            onHttpListener.empty();
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        onHttpListener.failed(response.code() + "");
                    }
                });
    }

    public abstract T parseJson(String json);

}