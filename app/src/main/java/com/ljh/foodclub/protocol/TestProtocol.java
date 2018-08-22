package com.ljh.foodclub.protocol;

import com.google.gson.Gson;
import com.ljh.foodclub.bean.TestBean;

/**
 * Description:
 * Date on 2018/7/12
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class TestProtocol extends BaseProtocol<TestBean> {

    @Override
    public TestBean parseJson(String json) {
        TestBean testBean = new Gson().fromJson(json, TestBean.class);
        return testBean;
    }
}
