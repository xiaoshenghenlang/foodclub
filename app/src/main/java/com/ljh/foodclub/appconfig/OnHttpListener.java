package com.ljh.foodclub.appconfig;

/**
 * Description:
 * Date on 2018/7/12
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public interface OnHttpListener {
    void success(String data);

    void empty();

    void failed(String message);
}
