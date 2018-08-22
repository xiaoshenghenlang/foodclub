package com.ljh.foodclub.views.dialog;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.ljh.foodclub.R;
import com.ljh.foodclub.utils.ToastEngine;

import java.util.List;


/**
 * Description:分享dialog
 * Date on 2018/4/3
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class ShareDialog extends Dialog implements View.OnClickListener {
    private ImageView wechatCommunity, wechatFriends, qqFriends, weibo;
    private Context context;

    public ShareDialog(Context context) {
        super(context, R.style.shareDialog);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_share);

        DialogParams();

        init();

    }

    //dialog参数设置
    private void DialogParams() {
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.BOTTOM;
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setAttributes(layoutParams);
        setCanceledOnTouchOutside(true);
    }


    //初始化点击事件
    private void init() {
        wechatFriends = (ImageView) findViewById(R.id.wechat_friends);
        wechatCommunity = (ImageView) findViewById(R.id.wechat_community);
        qqFriends = (ImageView) findViewById(R.id.qq_friends);
        weibo = (ImageView) findViewById(R.id.weibo);

        wechatFriends.setOnClickListener(this);
        wechatCommunity.setOnClickListener(this);
        qqFriends.setOnClickListener(this);
        weibo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.wechat_friends:
                if (isAppAvilible(context, "com.tencent.mm")) {
                    shareToWechatFriends();
                }else {
                    ToastEngine.showToast(context,"未安装微信");
                }
                break;
            case R.id.wechat_community:
                if (isAppAvilible(context, "com.tencent.mm")) {
                    shareToWechatCommunity();
                }else {
                    ToastEngine.showToast(context,"未安装微信");
                }
                break;
            case R.id.qq_friends:
                if (isAppAvilible(context, "com.tencent.mobileqq")) {
                    shareToQqFriends();
                }else {
                    ToastEngine.showToast(context,"未安装QQ");
                }
                break;
            case R.id.weibo:
                if (isAppAvilible(context, "com.sina.weibo")) {
                    shareToWeibo();
                }else {
                    ToastEngine.showToast(context,"未安装微博");
                }
                break;
        }
        this.dismiss();
    }

    /**
     * 分享至微信好友
     */
    private void shareToWechatFriends() {
        Intent intent = new Intent();
        ComponentName componentName = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
        intent.setComponent(componentName);
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, "这是分享内容");
        context.startActivity(intent);
    }

    /**
     * 分享至微信朋友圈
     */
    private void shareToWechatCommunity() {

    }

    /**
     * 分享至QQ好友
     */
    private void shareToQqFriends() {

    }

    /**
     * 分享至微博
     */
    private void shareToWeibo() {

    }

    /**
     * 判断App是否安装（判断QQ改包名就行啦"com.tencent.mobileqq"）
     *
     * @param context
     * @param packageName
     * @return
     */
    public static boolean isAppAvilible(Context context, String packageName) {
        // 获取packagemanager
        final PackageManager packageManager = context.getPackageManager();
        // 获取所有已安装程序的包信息
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals(packageName)) {
                    return true;
                }
            }
        }
        return false;
    }
}
