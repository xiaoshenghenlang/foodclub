package com.ljh.foodclub.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.ljh.foodclub.R;
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
public class GiftRankAdapter<T> extends CommonAdapter<T> {
    private Context context;

    public GiftRankAdapter(Context context, int layoutId, List<T> datas) {
        super(context, layoutId, datas);
        this.context = context;
    }

    @Override
    protected void convert(ViewHolder holder, T t, int position) {
        ImageView ivHead = holder.getView(R.id.iv_head);
        TextView tvRank = holder.getView(R.id.tv_rank);
        tvRank.setText(""+(position+4));
        ImgLoader.loadCircleImg(context,"http://upload.mnw.cn/2017/0814/1502698443378.jpg",ivHead);
    }
}
