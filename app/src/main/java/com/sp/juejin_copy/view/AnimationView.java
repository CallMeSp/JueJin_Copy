package com.sp.juejin_copy.view;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

/**
 * Created by my on 2016/12/1.
 */
public class AnimationView {
    private int duration=300;
    private Context context;
    private View animationview;
    private boolean isshow=true;
    public void hideTools(View view) {
        if (isshow){
            ObjectAnimator anim = ObjectAnimator.ofFloat(view, "y", view.getY(), view.getY()+ view.getHeight());
            anim.setDuration(duration);
            anim.start();
            isshow=false;
        }
    }
    public void showTools(View view){
        if (!isshow){
            ObjectAnimator anim = ObjectAnimator.ofFloat(view, "y", view.getY(), view.getY()-view.getHeight());
            anim.setDuration(duration);
            anim.start();

            isshow=true;
        }
    }
}
