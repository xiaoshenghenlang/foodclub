package com.ljh.foodclub.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.ljh.foodclub.R;
import com.ljh.foodclub.base.ImgLoader;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Date on 2018/6/28
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class LogAdapter<T> extends CommonAdapter<T> {
    private Context context;
    private ImageView ivHead;

    public LogAdapter(Context context, int layoutId, List datas) {
        super(context, layoutId, datas);
        this.context = context;
    }

    @Override
    protected void convert(ViewHolder holder, Object o, int position) {
        holder.setText(R.id.tv_name,"钱小佳");
        ivHead = holder.getView(R.id.iv_head);
        ImgLoader.loadCircleImg(context,"http://upload.mnw.cn/2017/0814/1502698443378.jpg", ivHead);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            list.add(i,"123");
        }
        RecyclerView rv = holder.getView(R.id.rv);
        rv.setLayoutManager(new GridLayoutManager(context,3));
        rv.setAdapter(new LogItemAdapter(context,R.layout.rv_item_log_img,list));
    }

}
