package com.ljh.foodclub.appconfig;

/**
 * Description:
 * Date on 2018/7/12
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class AppConfig {

    private static final String APP_HOST = "http://120.76.205.241:8000";

    public static String getHost(){
        return APP_HOST;
    }

    //测试接口
    public static final String test = "/news/qihoo?kw=%E7%99%BD&site=qq.com&pageToken=2&apikey=OMBOjdpMSIXok6wI3OivaLAFHqPf8BEcrzr2bS5dGuat5nZI5uKNW7PSJAhgKCuz";
}
