package com.ljh.foodclub.views.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.ljh.foodclub.R;

/**
 * Description:
 * Date on 2018/7/2
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */

public class LoadDialog {
    private Context context;
    private final Dialog loadDialog;

    public LoadDialog(Context context) {
        this.context = context;
        loadDialog = new Dialog(context, R.style.loadDialog);
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_load, null);
        loadDialog.setContentView(dialogView);
    }

    public void show(){
        loadDialog.show();
    }

    public void dismiss(){
        loadDialog.dismiss();
    }
}
