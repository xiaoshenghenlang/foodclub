package com.ljh.foodclub.utils;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

/**
 * Description:
 * Date on 2018/7/24
 * E-mail: lijiahongssg@163.com
 * Author: LJH
 */
public class AnimUtils {

    public static void startAnim(ImageView iv){
        //1.0f 代表默认大小
        ScaleAnimation sa = new ScaleAnimation(1.0f,1.2f,1.0f,1.2f, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        //设置动画执行的时长
        sa.setDuration(150);
        //设置动画重复执行的次数
        sa.setRepeatCount(1);
        //设置动画执行重复的模式
        sa.setRepeatMode(AlphaAnimation.REVERSE);
        //让iv执行动画
        iv.startAnimation(sa);
    }

}
