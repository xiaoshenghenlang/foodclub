package com.ljh.foodclub.activity;

import android.os.Bundle;
import android.widget.Button;

import com.ljh.foodclub.R;
import com.ljh.foodclub.base.BaseActivity;
import com.ljh.foodclub.utils.TransfromUtils;
import com.ljh.foodclub.views.dialog.ShareDialog;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description:
 * Date on 2018/6/20
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class SettingsActivity extends BaseActivity {
    @BindView(R.id.bt)
    Button bt;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settings;
    }

    @Override
    protected void initView() {
        file = TransfromUtils.drawableToFile(this, R.mipmap.ic_launcher, "abc","abc");
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void loadData() {

    }



    @OnClick(R.id.bt)
    public void onViewClicked() {
        ShareDialog shareDialog = new ShareDialog(this);
        shareDialog.show();
//        Intent share_intent = new Intent();
//        share_intent.setPackage("org.telegram.btcchat");
//        share_intent.setAction(Intent.ACTION_SEND);//设置分享行为
//
//        share_intent.setType("image/*");
//        share_intent.putExtra(Intent.EXTRA_STREAM, VersionUtils.isSeven(this,file,share_intent));
//        startActivity(share_intent);

//        share_intent.setType("text/plain");//设置分享内容的类型
//        share_intent.putExtra(Intent.EXTRA_SUBJECT, "12");//添加分享内容标题
//        share_intent.putExtra(Intent.EXTRA_TEXT, "23");//添加分享内容
        //创建分享的Dialog
//        share_intent = Intent.createChooser(share_intent, "34");
    }
}
