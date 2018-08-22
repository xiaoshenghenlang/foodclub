package com.ljh.foodclub.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.ljh.foodclub.R;
import com.ljh.foodclub.activity.ImgDetailActivity;
import com.ljh.foodclub.base.ImgLoader;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Description:
 * Date on 2018/6/28
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class LogItemAdapter<T> extends CommonAdapter<T> {
    private Context context;

    public LogItemAdapter(Context context, int layoutId, List datas) {
        super(context, layoutId, datas);
        this.context = context;
    }

    @Override
    protected void convert(ViewHolder holder, Object o, final int position) {
        ImageView iv = holder.getView(R.id.iv);
        ImgLoader.loadLocalImg(context,R.drawable.sights,iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ImgDetailActivity.class);
                intent.putExtra("position",position);
                context.startActivity(intent);
            }
        });
    }

}