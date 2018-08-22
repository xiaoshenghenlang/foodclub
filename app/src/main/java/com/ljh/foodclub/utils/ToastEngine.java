package com.ljh.foodclub.utils;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

/**
 * Description: TODO <br>
 *
 * @author ljh <br>
 * @version V1.0
 * @Copyright: Copyright (c) 2017 <br>
 * @date 2017/7/21  21:27 <br>
 */
public class ToastEngine {
    private static Toast toast;
    private static Toast toast_looper;


    /**
     * toast
     *
     * @param context
     * @param msg
     */
    public static void showToast(Context context, String msg) {
        boolean isMain = Looper.myLooper() == Looper.getMainLooper();
        if(context==null){
            return;
        }
        try {
            if (isMain) {
                if (toast == null) {
                    toast= Toast.makeText(context,msg,Toast.LENGTH_SHORT);
                }
                toast.setText(msg);
                toast.show();
            } else {
                Looper.prepare();
                if (toast_looper == null) {
                    toast_looper= Toast.makeText(context,msg,Toast.LENGTH_SHORT);
                }
                toast_looper.setText(msg);
                toast_looper.show();
                Looper.loop();
            }
        } catch (Throwable e) {
            try {
//                LogEngine.getInstance(context).save("Toast需要looper");
                Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            } catch (Throwable e1) {
                try {
                    Looper.prepare();
                    if (toast_looper == null) {
                        toast_looper = new Toast(context);
                        toast_looper.setDuration(Toast.LENGTH_SHORT);
                    }
                    toast_looper.setText(msg);
                    toast_looper.show();
                    Looper.loop();
                } catch (Throwable throwable) {
//                    LogEngine.getInstance(context).save("Toast用looper也出错");
                }
            }
        }
    }

}
