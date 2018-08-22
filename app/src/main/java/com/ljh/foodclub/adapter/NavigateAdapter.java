package com.ljh.foodclub.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ljh.foodclub.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import static android.R.attr.width;

/**
 * Description:
 * Date on 2018/7/6
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class NavigateAdapter<String> extends CommonAdapter<String>{
    private Context context;
    public NavigateAdapter(Context context, int layoutId, List<String> datas) {
        super(context, layoutId, datas);
        this.context = context;
    }

    @Override
    protected void convert(ViewHolder holder, String s, int position) {
        ImageView iv = holder.getView(R.id.iv);
        ViewGroup.LayoutParams params = iv.getLayoutParams();
        //设置图片的相对于屏幕的宽高比
        params.width = width/3;
        params.height =  (int) (200 + Math.random() * 400) ;
        iv.setLayoutParams(params);
        Glide.with(context).load(getDatas().get(position)).into(iv);
//        ImgLoader.loadImg(context, (java.lang.String) getDatas().get(position),iv,false);
    }
}
