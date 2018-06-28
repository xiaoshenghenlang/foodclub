package com.ljh.foodclub.fragment.otherfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.ljh.foodclub.R;
import com.ljh.foodclub.adapter.GiftRankAdapter;
import com.ljh.foodclub.base.BaseFragment;
import com.ljh.foodclub.base.ImgLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Description:
 * Date on 2018/6/27
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class GiftRankFragment extends BaseFragment {

    @BindView(R.id.iv_head_second)
    ImageView ivHeadSecond;
    @BindView(R.id.iv_head_first)
    ImageView ivHeadFirst;
    @BindView(R.id.iv_head_third)
    ImageView ivHeadThird;
    @BindView(R.id.rv)
    RecyclerView rv;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gift;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView(View view) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(i,"123");
        }
        ImgLoader.loadCircleImg(getContext(),"http://upload.mnw.cn/2017/0814/1502698443378.jpg",ivHeadSecond);
        ImgLoader.loadCircleImg(getContext(),"http://upload.mnw.cn/2017/0814/1502698443378.jpg",ivHeadFirst);
        ImgLoader.loadCircleImg(getContext(),"http://upload.mnw.cn/2017/0814/1502698443378.jpg",ivHeadThird);
        rv.setAdapter(new GiftRankAdapter(getContext(),R.layout.rv_item_giftrank,list));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setFocusableInTouchMode(false);
        rv.requestFocus();
    }

    @Override
    protected void initListeners() {

    }

}
