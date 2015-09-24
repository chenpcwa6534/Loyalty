package com.astuetz.view.fortune;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.astuetz.pagerslidingtabstrip.R;

import java.util.Random;

/**
 * Created by MTel on 2015/9/21.
 */
public class WheelOfFortune extends RelativeLayout{
    private String TAG =WheelOfFortune.class.getSimpleName();

    private static final long ONE_WHEEL_TIME = 500;
    private static final int LABS_MAX = 10;
    private static final int LABS_MIN = 5;
    private int mStartDegree = 0;

    private ImageView mBackground;
    private ImageButton mPointer;

    private WheelListener mListener;

    /** test data*/
    private String[] data = new String[4];
    private int index = 2;

    interface WheelListener{
        void onWheelEnd();
    }

    public WheelOfFortune(Context context) {
        super(context);
        initView();
    }

    public WheelOfFortune(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public WheelOfFortune(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    private void initView(){
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View mView = layoutInflater.inflate(R.layout.layout_wheeloffortune, null);
        mBackground = (ImageView) mView.findViewById(R.id.background);
        mPointer = (ImageButton) mView.findViewById(R.id.pointer);

        mPointer.setOnClickListener(onClickListener);
        addView(mView);
    }

    private void startAnimation(int angle_data){
        int labs = (int) (Math.random() * LABS_MAX + LABS_MIN);
        int angles_start = (360 * labs) + (angle_data * index);
        int angles = (int) (Math.random() * angle_data + angles_start);
        RotateAnimation rotateAnimation = new RotateAnimation(mStartDegree, angles,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f
                ,RotateAnimation.RELATIVE_TO_SELF,0.6f);
        long time = (angles / 360) * ONE_WHEEL_TIME;
        rotateAnimation.setDuration(time);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(getContext(), android.R.anim.accelerate_decelerate_interpolator);
        rotateAnimation.setAnimationListener(animationListener);
        mPointer.startAnimation(rotateAnimation);
    }

    private Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if(mListener != null){
                mListener.onWheelEnd();
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            int angle_data = 360 / data.length;
            startAnimation(angle_data);
        }
    };

    public void setCallback(WheelListener listener){
            this.mListener = listener;
    }
}
