package com.ljh.foodclub.base;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ljh.foodclub.R;
import com.ljh.foodclub.utils.ClipboardManagerUtils;
import com.ljh.foodclub.views.dialog.MoreDialog;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:
 * Date on 2018/7/4
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class BaseWebActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.tv_load_error)
    TextView tvLoadError;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.webview)
    WebView webview;
    private String url, title;
    private MoreDialog moreDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_baseweb;
    }

    @Override
    protected void dealIntentData() {
        Intent intent = getIntent();
        try {
            url = intent.getStringExtra("url");
            title = intent.getStringExtra("title");
        } catch (NullPointerException e) {
        }
    }

    @Override
    protected void initView() {
        moreDialog = new MoreDialog(this);
        WebViewClient webViewClient = new WebViewClient();
        webview.setWebViewClient(webViewClient);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.setProgress(newProgress);
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                tvTitle.setText(title);
            }

        });


    }

    @Override
    protected void initListeners() {
        moreDialog.setOnItemMoreClick(new MoreDialog.OnItemMoreClick() {
            @Override
            public void onRefresh() {
                webview.reload();
            }

            @Override
            public void onCopyUrl() {
                ClipboardManagerUtils.save(BaseWebActivity.this, url);
            }

            @Override
            public void onOpenBrowser() {
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void loadData() {
        if (!TextUtils.isEmpty(url)) {
            //加载url
            webview.loadUrl(url);
        } else {
            tvLoadError.setVisibility(View.VISIBLE);
        }
        if (!TextUtils.isEmpty(title)) {
            //设置标题
//            tvTitle.setText(title);
        }
    }


    @OnClick({R.id.iv_back, R.id.iv_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                back();
                break;
            case R.id.iv_more:
                moreDialog.show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        if (webview != null) {
            webview.destroy();
            webview = null;
        }
        super.onDestroy();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //这是一个监听用的按键的方法，keyCode 监听用户的动作，如果是按了返回键，同时Webview要返回的话，WebView执行回退操作，因为mWebView.canGoBack()返回的是一个Boolean类型，所以我们把它返回为true
        if (keyCode == KeyEvent.KEYCODE_BACK && webview.canGoBack()) {
            webview.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
