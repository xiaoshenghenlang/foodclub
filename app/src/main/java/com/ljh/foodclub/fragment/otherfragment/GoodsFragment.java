package com.ljh.foodclub.fragment.otherfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ljh.foodclub.R;
import com.ljh.foodclub.adapter.GoodsAdapter;
import com.ljh.foodclub.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Description:
 * Date on 2018/6/27
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class GoodsFragment extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_goods;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView(View view) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i,"123");
        }
        //NestScrollView嵌套recycleview处理卡顿
        rv.setHasFixedSize(true);
        rv.setNestedScrollingEnabled(false);
        rv.setAdapter(new GoodsAdapter(getContext(),R.layout.rv_item_goods,list));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setFocusableInTouchMode(false);
        rv.requestFocus();
    }

    @Override
    protected void initListeners() {

    }

}
