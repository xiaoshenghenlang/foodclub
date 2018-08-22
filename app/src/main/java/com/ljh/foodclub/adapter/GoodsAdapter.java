package com.ljh.foodclub.adapter;

import android.content.Context;

import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Description:
 * Date on 2018/6/28
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class GoodsAdapter<T> extends CommonAdapter<T>{

    private Context context;

    public GoodsAdapter(Context context, int layoutId, List<T> datas) {
        super(context, layoutId, datas);
        this.context = context;
    }

    @Override
    protected void convert(ViewHolder holder, T t, int position) {
    }
}
