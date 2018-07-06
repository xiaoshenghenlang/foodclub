package com.ljh.foodclub.fragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.ljh.foodclub.R;
import com.ljh.foodclub.adapter.NavigateAdapter;
import com.ljh.foodclub.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Description:
 * Date on 2018/6/20
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class NavigateFragment extends BaseFragment {

    @BindView(R.id.rv)
    RecyclerView rv;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_navigate;
    }

    @Override
    protected void loadData() {
        List<String> list = new ArrayList<>();
        list.add(0, "http://upload.mnw.cn/2017/0814/1502698443378.jpg");
        list.add(1, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg");
        list.add(2, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg");
        list.add(3, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg");
        list.add(4, "http://upload.mnw.cn/2017/0814/1502698443378.jpg");
        list.add(5, "http://upload.mnw.cn/2017/0814/1502698443378.jpg");
        list.add(6, "http://upload.mnw.cn/2017/0814/1502698443378.jpg");
        list.add(7, "http://upload.mnw.cn/2017/0814/1502698443378.jpg");
        list.add(8, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg");
        list.add(9, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg");
        NavigateAdapter navigateAdapter = new NavigateAdapter(getContext(), R.layout.rv_item_navigate, list);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        rv.setLayoutManager(staggeredGridLayoutManager);
        rv.setAdapter(navigateAdapter);
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                staggeredGridLayoutManager.invalidateSpanAssignments();//这行主要解决了当加载更多数据时，底部需要重绘，否则布局可能衔接不上。
            }
        });
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initListeners() {

    }

}
