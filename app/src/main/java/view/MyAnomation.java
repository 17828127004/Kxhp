package view;

import android.app.Dialog;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.kxhl.R;

/**
 * Created by Administrator on 2017/4/6.
 */

public class MyAnomation extends Dialog{
    private Context context;
    private static MyAnomation myAnomation;
    private ImageView iv;
    private MyAnomation(Context context) {
        super(context);
        this.context = context;
        setContentView(R.layout.loadingxml);
        iv=(ImageView)findViewById(R.id.iv_loading);
    }

    public static MyAnomation getInstace(Context mContext) {
        if (myAnomation == null)
            myAnomation = new MyAnomation(mContext);
        return myAnomation;
    }
    public void getAnimation(){
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1,0.5f,1,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(2000);
        //将AlphaAnimation这个已经设置好的动画添加到 AnimationSet中
        animationSet.addAnimation(scaleAnimation);
        iv.startAnimation(animationSet);
    }


}
