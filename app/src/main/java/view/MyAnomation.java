package view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.kxhl.R;

/**
 * Created by Administrator on 2017/4/6.
 */

public class MyAnomation extends Dialog {
    private ImageView iv;

    public MyAnomation(Context context) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(R.layout.animation_layout);
        iv = (ImageView) findViewById(R.id.iv_loading);
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.1f, 0.85f, 1.1f, 0.85f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        //3秒完成动画
        scaleAnimation.setDuration(300);
        //将AlphaAnimation这个已经设置好的动画添加到 AnimationSet中
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        animationSet.addAnimation(scaleAnimation);
        //启动动画
        iv.startAnimation(animationSet);
    }
}
