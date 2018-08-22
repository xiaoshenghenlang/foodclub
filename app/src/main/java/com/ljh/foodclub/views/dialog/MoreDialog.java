package com.ljh.foodclub.views.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.ljh.foodclub.R;

/**
 * Description:
 * Date on 2018/7/5
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class MoreDialog extends Dialog implements View.OnClickListener{
//    @BindView(R.id.tv_refresh)
//    TextView tvRefresh;
//    @BindView(R.id.tv_copy_url)
//    TextView tvCopyUrl;
//    @BindView(R.id.tv_open_browser)
//    TextView tvOpenBrowser;
    private OnItemMoreClick onItemMoreClick;
    private TextView tvRefresh;
    private TextView tvCopyUrl;
    private TextView tvOpenBrowser;

    public MoreDialog(Context context) {
        super(context, R.style.moreDialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_more);

        initView();
        DialogParams();
    }

    private void initView() {
        tvRefresh = (TextView) findViewById(R.id.tv_refresh);
        tvCopyUrl = (TextView) findViewById(R.id.tv_copy_url);
        tvOpenBrowser = (TextView) findViewById(R.id.tv_open_browser);
        tvRefresh.setOnClickListener(this);
        tvCopyUrl.setOnClickListener(this);
        tvOpenBrowser.setOnClickListener(this);
    }

    public void setOnItemMoreClick(OnItemMoreClick onItemMoreClick) {
        this.onItemMoreClick = onItemMoreClick;
    }

    //dialog参数设置
    private void DialogParams() {
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        WindowManager.LayoutParams wl = window.getAttributes();
        layoutParams.gravity = Gravity.TOP | Gravity.RIGHT;
        //根据x，y坐标设置窗口需要显示的位置
//        wl.x = 50; //x小于0左移，大于0右移
//        wl.y = 95; //y小于0上移，大于0下移

        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setAttributes(layoutParams);
        setCanceledOnTouchOutside(true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_refresh:
                onItemMoreClick.onRefresh();
                break;
            case R.id.tv_copy_url:
                onItemMoreClick.onCopyUrl();
                break;
            case R.id.tv_open_browser:
                onItemMoreClick.onOpenBrowser();
                break;
        }
        this.dismiss();
    }

//    @OnClick({R.id.tv_refresh, R.id.tv_copy_url, R.id.tv_open_browser})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.tv_refresh:
//                onItemMoreClick.onRefresh();
//                break;
//            case R.id.tv_copy_url:
//                onItemMoreClick.onCopyUrl();
//                break;
//            case R.id.tv_open_browser:
//                onItemMoreClick.onOpenBrowser();
//                break;
//        }
//        this.dismiss();
//    }

    public interface OnItemMoreClick {

        void onRefresh();

        void onCopyUrl();

        void onOpenBrowser();
    }
}
