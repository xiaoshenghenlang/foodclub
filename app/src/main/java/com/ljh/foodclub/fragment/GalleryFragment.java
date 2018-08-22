package com.ljh.foodclub.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ljh.foodclub.R;
import com.ljh.foodclub.activity.IdolInfoActivity;
import com.ljh.foodclub.activity.PhotoViewActivity;
import com.ljh.foodclub.appconfig.AppConfig;
import com.ljh.foodclub.appconfig.OnHttpListener;
import com.ljh.foodclub.base.BaseFragment;
import com.ljh.foodclub.base.ImgLoader;
import com.ljh.foodclub.bean.TestBean;
import com.ljh.foodclub.protocol.TestProtocol;
import com.ljh.foodclub.views.custom.layoutmanager.EchelonLayoutManager;

import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;

/**
 * Description:
 * Date on 2018/6/20
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class GalleryFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.rl_next)
    RelativeLayout rlNext;
    @BindView(R.id.iv_user)
    ImageView ivUser;
    @BindView(R.id.iv_refresh)
    ImageView ivRefresh;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.rl)
    RelativeLayout rl;
    @BindView(R.id.iv_frag_bg)
    ImageView ivFragBg;
    @BindView(R.id.tv_fans_num)
    TextView tvFans;
    private List<TestBean.DataBean> list;
    private MyAdapter myAdapter;
    private Gson gson;
    private List<TestBean.DataBean> list1;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_gallery;
    }

    @Override
    protected void loadData() {
        loadImg("http://upload.mnw.cn/2017/0814/1502698443378.jpg", "http://upload.mnw.cn/2017/0814/1502698443378.jpg");
    }

    private void loadImg(String url1, String url2) {
        ImgLoader.loadHeadImg(getActivity(), url1, ivUser);
        ImgLoader.loadDimImg(getActivity(), url2, ivFragBg, 25);

        TestProtocol testProtocol = new TestProtocol();
        TreeMap<String,Object> map = new TreeMap<>();
        map.put("pageToken",1);
        testProtocol.getDataFromNet(AppConfig.test, map, new OnHttpListener() {
            @Override
            public void success(String data) {
//                LogUtils.e(getActivity(),data);
//                TestBean testBean = new Gson().fromJson(data, TestBean.class);
//                list1 = testBean.getData();
//                String[] imageUrls = list1.get(1).getImageUrls();
//                LogUtils.e(getActivity(),imageUrls[0]);
            }

            @Override
            public void empty() {

            }

            @Override
            public void failed(String message) {

            }
        });
    }

    @Override
    protected void initView(View view) {
//        for (int i = 0; i < 10; i++) {
//            list.add(i,new TestBean.ImgUrl());
//            list.get(i).setUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg");
//        }
        rv.setLayoutManager(new EchelonLayoutManager(getContext()));
        myAdapter = new MyAdapter();
        rv.setAdapter(myAdapter);
        String json = "{\n" +
                "\t\"data\": [{\n" +
                "\t\t\"url\": \"http://img1.3lian.com/2015/w22/9/d/23.jpg\"\n" +
                "\t}, {\n" +
                "\t\t\"url\": \"http://img1.3lian.com/2015/w22/9/d/23.jpg\"\n" +
                "\t}, {\n" +
                "\t\t\"url\": \"http://img1.3lian.com/2015/w22/9/d/23.jpg\"\n" +
                "\t}, {\n" +
                "\t\t\"url\": \"http://img1.3lian.com/2015/w22/9/d/23.jpg\"\n" +
                "\t}, {\n" +
                "\t\t\"url\": \"http://img1.3lian.com/2015/w22/9/d/23.jpg\"\n" +
                "\t}, {\n" +
                "\t\t\"url\": \"http://img1.3lian.com/2015/w22/9/d/23.jpg\"\n" +
                "\t}, {\n" +
                "\t\t\"url\": \"http://img1.3lian.com/2015/w22/9/d/23.jpg\"\n" +
                "\t}, {\n" +
                "\t\t\"url\": \"http://img1.3lian.com/2015/w22/9/d/23.jpg\"\n" +
                "\t}, {\n" +
                "\t\t\"url\": \"http://img1.3lian.com/2015/w22/9/d/23.jpg\"\n" +
                "\t}, {\n" +
                "\t\t\"url\": \"http://img1.3lian.com/2015/w22/9/d/23.jpg\"\n" +
                "\t}]\n" +
                "}";
        gson = new Gson();
        TestBean testBean = gson.fromJson(json, TestBean.class);
        list = testBean.getData();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_user:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Intent intent = new Intent(getContext(), IdolInfoActivity.class);
                    ActivityOptions options = null;
                    options = ActivityOptions.makeSceneTransitionAnimation(
                            getActivity(),
                            ivUser,
                            "acb");
                    startActivity(intent, options.toBundle());
//                    startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
//                    getActivity().overridePendingTransition(0, 0);
                } else {
                    Intent intent = new Intent(getContext(), IdolInfoActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.rv_item_cool_ech, null);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            if (position == 0) {
            }
            ImgLoader.loadImg(getContext(), list.get(position).getUrl(), holder.iv, true);
            holder.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityOptions options = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                        Intent intent = new Intent(getContext(), PhotoViewActivity.class);
                        options = ActivityOptions.makeSceneTransitionAnimation(
                                getActivity(),
                                holder.iv,
                                "abc");
                        intent.putExtra("imgurl", list.get(position).getUrl());
                        startActivity(intent, options.toBundle());
                        getActivity().overridePendingTransition(0, 0);
                    } else {
                        Intent intent = new Intent(getContext(), PhotoViewActivity.class);
                        startActivity(intent);
                    }
//                    startActivity(intent);
                }
            });
            Log.i("MyAdapter", "onBindViewHolder: " + holder.iv.getWidth() + "----" + holder.iv.getHeight());
            holder.llLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "点赞了第" + (position + 1) + "个", Toast.LENGTH_SHORT).show();
                }
            });
        }


        @Override
        public int getItemCount() {
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            ImageView iv;
            LinearLayout llLike;

            public ViewHolder(View view) {
                super(view);
                iv = (ImageView) view.findViewById(R.id.iv);
                llLike = (LinearLayout) view.findViewById(R.id.ll_like);
            }
        }
    }


    @Override
    protected void initListeners() {
        ivUser.setOnClickListener(this);
        ivRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = "{\n" +
                        "\t\"data\": [{\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}]\n" +
                        "}";
                TestBean testBean = gson.fromJson(json, TestBean.class);
                List<TestBean.DataBean> alist = testBean.getData();
                list.clear();
                list.addAll(alist);
                myAdapter.notifyDataSetChanged();
            }
        });
        rlNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg");
                String json = "{\n" +
                        "\t\"data\": [{\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}, {\n" +
                        "\t\t\"url\": \"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529574459801&di=c64eb80d33496b15f5a9196d324ae00d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2%2F5513a456c6708.jpg\"\n" +
                        "\t}]\n" +
                        "}";
                TestBean testBean = gson.fromJson(json, TestBean.class);
                List<TestBean.DataBean> alist = testBean.getData();
                list.clear();
                list.addAll(alist);
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}
