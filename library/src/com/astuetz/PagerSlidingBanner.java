package com.astuetz;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.astuetz.pagerslidingtabstrip.R;

/**
 * Created by MTel on 2015/6/26.
 */
public class PagerSlidingBanner extends RelativeLayout{

    private static final int[] ATTRS = new int[] {
            android.R.attr.width,
            android.R.attr.height
    };

    private String TAG = PagerSlidingBanner.class.getSimpleName();

    private Context mContext;

    private int bannerWidth;
    private int bannerHeight;
    private int CarouselTime;

    public PagerSlidingBanner(Context context) {
        super(context);
    }

    public PagerSlidingBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PagerSlidingBanner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initAttrs(AttributeSet attrs){
        TypedArray a = getContext().obtainStyledAttributes(attrs, ATTRS);
        bannerWidth = a.getLayoutDimension(0, android.R.attr.height);
        bannerHeight = a.getLayoutDimension(0, android.R.attr.width);
    }

    private void initView(){

    }

    private void initViewPager(){
        ViewPager viewPager = new ViewPager(getContext());

    }

    private void initDot(){

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
