package com.ljh.foodclub.base;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by wgt on 2018/4/10.
 */

public class MyActivityManager {
    //单例模式：饿汉式
    private MyActivityManager(){

    }
    private static MyActivityManager activityManager = new MyActivityManager();

    public static MyActivityManager getInstance(){
        return activityManager;
    }

    //提供栈的对象
    private Stack<Activity> activityStack = new Stack<>();

    //activity的添加
    public void add(Activity activity){
        if(activity != null){
            activityStack.add(activity);
        }
    }

    //删除指定的activity
    public void remove(Activity activity){
        if(activity != null){
            for(int i = activityStack.size() - 1;i >= 0;i--){
                Activity currentActivity = activityStack.get(i);
                if(currentActivity.getClass().equals(activity.getClass())){
                    currentActivity.finish();//销毁当前的activity
                    activityStack.remove(i);//从栈空间移除
                }
            }
        }
    }

    //删除当前的activity
    public void removeCurrent(){
        Activity activity = activityStack.lastElement();
        activity.finish();
        activityStack.remove(activity);
    }

    //删除所有的activity
    public void removeAll(){
        for (int i = activityStack.size() - 1;i >= 0;i--){
            Activity activity = activityStack.get(i);
            activity.finish();
            activityStack.remove(activity);
        }
    }

    //返回栈大小
    public int size(){
        return activityStack.size();
    }
}
