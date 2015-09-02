package com.astuetz.page.sliding;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.astuetz.com.adapter.ViewPagerAdapter;
import com.astuetz.pagerslidingtabstrip.R;
import com.astuetz.utility.PicassoUtility;

import java.util.ArrayList;


/**
 * Created by MTel on 2015/6/30.
 */
public class PageSlidingPagerView extends RelativeLayout implements ViewPager.OnPageChangeListener{
    private String TAG = PageSlidingPagerView.class.getSimpleName();

    private Context mContext;
    private LinearLayout mDotView;
    private ImageView[] mDot;
    private ViewPager mViewPager;
    private View mView;

    private ViewPagerAdapter mViewpagerAdapter;
    private PagerSlidingCallBack mPagerSlidingCallBack;

    private ArrayList<View> pages;
    private int currentIndex;
    private Handler handler = new Handler();

    private int IMAGE_DELAY = 0;

    private boolean isDot = true;

    private int DotMargin_Left = 0;
    private int DotMargin_Right = 0;
    private int DotMargin_Top = 0;
    private int DotMargin_Bottom = 15;
    private int DotPadding_Left = 5;
    private int DotPadding_Right = 5;
    private int DotPadding_Top = 0;
    private int DotPadding_Bottom = 0;
    private int Dot_Width = 25;
    private int Dot_Height = 15;
    private Drawable DotDrawable_Current = getResources().getDrawable(R.drawable.dot_white);;
    private Drawable DotDrawable_background = getResources().getDrawable(R.drawable.dot_gray);

    public static int DOTLOCATION_TOP = 0x333333;
    public static int DOTLOCATION_BOTTOM = 0x333334;
    private int DotLocation = DOTLOCATION_BOTTOM;
    public PageSlidingPagerView(Context context) {
        super(context);
        this.mContext = context;
    }

    public PageSlidingPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    private void initViewPager(){
        mViewPager = new ViewPager(mContext);
        mViewpagerAdapter = new ViewPagerAdapter(mContext,pages,viewpageCallback);
        mViewPager.setAdapter(mViewpagerAdapter);
        mViewPager.setOnPageChangeListener(this);
    }

    private void initDot(){
        mDotView = new LinearLayout(mContext);
        mDotView.setOrientation(LinearLayout.HORIZONTAL);
        mDotView.removeAllViews();
        mDot = new ImageView[pages.size()];

        for(int i = 0; i < mDot.length; i++){
            ImageView DotImage = new ImageView(mContext);
            DotImage.setImageDrawable(DotDrawable_background);
            DotImage.invalidate();
            LinearLayout.LayoutParams DotSize=new LinearLayout.LayoutParams(Dot_Width,Dot_Height);
            DotSize.setMargins(DotMargin_Left, DotMargin_Top, DotMargin_Right, DotMargin_Bottom);
            DotImage.setLayoutParams(DotSize);
            DotImage.setPadding(DotPadding_Left, DotPadding_Top, DotPadding_Right, DotPadding_Bottom);
            mDotView.addView(DotImage);
            mDot[i] = (ImageView) mDotView.getChildAt(i);
            mDot[i].setEnabled(true);//都設為灰色
            mDot[i].setTag(i);//設置位置tag，方便取出與當前位置對應
        }
        currentIndex = 0;
        if(mDot.length>0)
            mDot[currentIndex].setImageDrawable(DotDrawable_Current);
    }

    private void setCurDot(int positon){
        if(mDot.length <= positon)return;
        if(positon != currentIndex){
            mDot[positon].setImageDrawable(DotDrawable_Current);
            mDot[currentIndex].setImageDrawable(DotDrawable_background);
            currentIndex = positon;
        }
    }

    private DisplayMetrics getScreenSize(){
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }

    public void setViewPagerData(int[] data){
        pages = new ArrayList<>();
        for(int i=0; i<data.length; i++){
            ImageView imageView = new ImageView(mContext);
            imageView.setImageResource(data[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            View view = (View) imageView;
            pages.add(view);
        }
    }

    public void setViewPagerData(String[] data){
        pages = new ArrayList<>();
        for(int i=0; i<data.length; i++){
            ImageView imageView = new ImageView(mContext);
            PicassoUtility.load(mContext, imageView, data[i]);
            View view = (View) imageView;
            pages.add(view);
        }
    }

    public void setViewPagerData(View[] data){
        pages = new ArrayList<>();
        for(int i=0; i<data.length; i++){
            pages.add(data[i]);
        }
    }

    public void setPagerSelectedCallBack(PagerSlidingCallBack pagerSlidingCallBack){
        this.mPagerSlidingCallBack = pagerSlidingCallBack;
    }

    public void setCarouselTime(int time){
        this.IMAGE_DELAY = time;
    }

    public void setDotSize(int Width, int Height){
        this.Dot_Width = Width;
        this.Dot_Height = Height;
    }

    public void setDotLocation(int location){
        this.DotLocation = location;
    }

    public void setDotPadding(int left, int top, int right, int bottom){
        this.DotPadding_Left = left;
        this.DotPadding_Top = top;
        this.DotPadding_Right = right;
        this.DotPadding_Bottom =bottom;
    }

    public void setDotMargin(int left, int top, int right, int bottom){
        this.DotMargin_Left = left;
        this.DotMargin_Top = top;
        this.DotMargin_Right =right;
        this.DotMargin_Bottom = bottom;
    }

    public void setDotDrawable(Drawable current, Drawable background){
        this.DotDrawable_Current = current;
        this.DotDrawable_background = background;
    }

    public void setDotStaus(boolean staus){
        this.isDot = staus;
    }

    public boolean isDotStatus(){
        return this.isDot;
    }

    public void startAutoTime(){
        if(IMAGE_DELAY !=0){
            handler.postDelayed(updateTimer, IMAGE_DELAY);
        }else{
            Log.d(TAG,"Carousel time is 0,so Carousel can't start, if want start carousel plase call setCarouselTime() setting delay");
        }
    }

    public void removeAutoTime(){
        if(IMAGE_DELAY !=0){
            handler.removeCallbacks(updateTimer);
        }else{
            Log.d(TAG,"Carousel time is 0,so Carousel can't start, if want start carousel plase call setCarouselTime() setting delay");
        }

    }

    private void setDotLocation(){
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) mDotView.getLayoutParams();
        lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        if(DotLocation == DOTLOCATION_BOTTOM){
            lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            lp.setMargins(0,0,0,30);
        }else if(DotLocation == DOTLOCATION_TOP){
            lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            lp.setMargins(0,30,0,0);
        }
        mDotView.setLayoutParams(lp);
        mDotView.bringToFront();
    }

    public void show(){
       initViewPager();
        this.addView(mViewPager);

       if(isDot){
           initDot();
           this.addView(mDotView);
           setDotLocation();
       }
    }

    /**
     * This method will be invoked when the current page is scrolled, either as part
     * of a programmatically initiated smooth scroll or a user initiated touch scroll.
     *
     * @param position             Position index of the first page currently being displayed.
     *                             Page position+1 will be visible if positionOffset is nonzero.
     * @param positionOffset       Value from [0, 1) indicating the offset from the page at position.
     * @param positionOffsetPixels Value in pixels indicating the offset from position.
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * This method will be invoked when a new page becomes selected. Animation is not
     * necessarily complete.
     *
     * @param position Position index of the new selected page.
     */
    @Override
    public void onPageSelected(int position) {
        if(mViewpagerAdapter.getOriginalCount()!=0)
            position = position % mViewpagerAdapter.getOriginalCount();
        setCurDot(position);
        if(mPagerSlidingCallBack != null){
            mPagerSlidingCallBack.CurrentItem(position);
        }
    }

    /**
     * Called when the scroll state changes. Useful for discovering when the user
     * begins dragging, when the pager is automatically settling to the current page,
     * or when it is fully stopped/idle.
     *
     * @param state The new scroll state.
     * @see ViewPager#SCROLL_STATE_IDLE
     * @see ViewPager#SCROLL_STATE_DRAGGING
     * @see ViewPager#SCROLL_STATE_SETTLING
     */
    @Override
    public void onPageScrollStateChanged(int state) {
        if(IMAGE_DELAY != 0){
            switch (state){
                case ViewPager.SCROLL_STATE_DRAGGING:
                    //start drag
                    handler.removeCallbacks(updateTimer);
                    break;
                case ViewPager.SCROLL_STATE_SETTLING:
                    //middle drag
                    break;
                case ViewPager.SCROLL_STATE_IDLE:
                    //end drag
                    handler.postDelayed(updateTimer, IMAGE_DELAY);
                    break;

            }
        }
    }

    //固定要執行的方法
    private Runnable updateTimer = new Runnable() {
        public void run() {
            int nextItemIndex = mViewPager.getCurrentItem()+1;
            mViewPager.setCurrentItem(nextItemIndex);
            //設定定時要執行的方法
            handler.removeCallbacks(updateTimer);
            //設定Delay的時間
            handler.postDelayed(updateTimer, IMAGE_DELAY);
        }
    };

    public interface PagerSlidingCallBack{
        void CurrentItem(int position);
        void onClick(int position);
    }

    private ViewPagerAdapter.ViewpageCallback viewpageCallback = new ViewPagerAdapter.ViewpageCallback() {
        @Override
        public void onClick(int position) {
           if(mPagerSlidingCallBack != null){
               mPagerSlidingCallBack.onClick(position);
           }
        }
    };
}
