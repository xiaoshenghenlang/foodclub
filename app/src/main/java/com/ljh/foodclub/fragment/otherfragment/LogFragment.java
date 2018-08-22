package com.ljh.foodclub.fragment.otherfragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.ljh.foodclub.R;
import com.ljh.foodclub.adapter.LogAdapter;
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
public class LogFragment extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.swiperefreshlayout)
    SwipeRefreshLayout swiperefreshlayout;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_log;
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initView(View view) {
        swiperefreshlayout.setColorSchemeColors(getResources().getColor(R.color.main_color));
        swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "刷新完成", Toast.LENGTH_SHORT).show();
                swiperefreshlayout.setRefreshing(false);
            }
        });
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i,"123");
        }

        //NestScrollView嵌套recycleview处理卡顿
        rv.setHasFixedSize(true);
        rv.setNestedScrollingEnabled(false);
        rv.setAdapter(new LogAdapter(getContext(),R.layout.rv_item_log,list));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    protected void initListeners() {

    }

}
