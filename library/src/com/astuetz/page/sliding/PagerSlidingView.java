package com.astuetz.page.sliding;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.astuetz.com.adapter.ViewPagerAdapter;
import com.astuetz.pagerslidingtabstrip.R;

import java.util.ArrayList;

/**
 * Created by MTel on 2015/6/29.
 */
public class PagerSlidingView extends Fragment implements ViewPager.OnPageChangeListener{

    private String TAG = PagerSlidingView.class.getSimpleName();
    private Context mContext;

    private LinearLayout mDotView;
    private ViewPager mViewPager;
    private View mView;
    private ImageView[] mDot;
    private ViewPagerAdapter mViewpagerAdapter;
    private ViewPagerAdapter.ViewpageCallback mListener;

    private ArrayList<Object> data;
    private ArrayList<Integer> viewType_Single;
    private ArrayList<View> pages;
    private int viewType_Full = 0;
    private int currentIndex;
    private boolean isDot = true;
    private boolean isAuto = false;

    public static int VIEWTYPE_IMAGEVIEW = 0x431312;
    public static int VIEWTYPE_VEODOVIEW = 0x431313;

    private int IMAGE_DELAYDE = 0;
    private Handler handler = new Handler();

    public PagerSlidingView() {
        super();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.layout_viewpager, container, false);
        show();
        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void initView(View v){
        mDotView = (LinearLayout) v.findViewById(R.id.dot);
        mViewPager = (ViewPager) v.findViewById(R.id.ViewPager);
    }

    private void initViewPager(){
        mViewpagerAdapter = new ViewPagerAdapter(getActivity(),pages,mListener);
        mViewPager.setAdapter(mViewpagerAdapter);
        mViewPager.setOnPageChangeListener(this);
    }

    private void initDot(){
        if(mDotView==null)return;
        mDotView.removeAllViews();
        mDot = new ImageView[pages.size()];

        for(int i = 0; i < mDot.length; i++){
            ImageView DotImage = new ImageView(getActivity());
            DotImage.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.dot_gray));
            DotImage.invalidate();
            ViewGroup.LayoutParams DotSize=new ViewGroup.LayoutParams(25,15);
            DotImage.setLayoutParams(DotSize);
            DotImage.setPadding(5, 0, 5, 0);
            mDotView.addView(DotImage);
            mDot[i] = (ImageView) mDotView.getChildAt(i);
            mDot[i].setEnabled(true);//都設為灰色
            mDot[i].setTag(i);//設置位置tag，方便取出與當前位置對應
        }
        currentIndex = 0;
        if(mDot.length>0)
            mDot[currentIndex].setImageDrawable(getResources().getDrawable(R.drawable.dot_white));
    }

    private void initAutoCarousel(){
        if (IMAGE_DELAYDE != 0) {
            handler.postDelayed(updateTimer, IMAGE_DELAYDE);
        }
    }

    private void removeAutoCarousel(){
        if(IMAGE_DELAYDE != 0){
            handler.removeCallbacks(updateTimer);
        }
    }

    public void show(){
        initTestData();
        if(pages.size() != 0){
            initView(mView);
            initViewPager();
            if(isDot){
                initDot();
            }
        }
    }

    public void setCarouselTime(int time){
        this.IMAGE_DELAYDE = time;
    }

    private void initTestData(){
        pages = new ArrayList<>();
        int[] resources = new int[]{R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
        for(int i=0; i<resources.length; i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(resources[i]);
            View view = (View) imageView;
            pages.add(view);
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
        switch (state){
            case ViewPager.SCROLL_STATE_DRAGGING:
                //start drag
                removeAutoCarousel();
                break;
            case ViewPager.SCROLL_STATE_SETTLING:
                //middle drag
                break;
            case ViewPager.SCROLL_STATE_IDLE:
                //end drag
                initAutoCarousel();
                break;

        }
    }

    private void setCurDot(int positon){
        if(mDot.length <= positon)return;
        if(positon != currentIndex){

            mDot[positon].setImageDrawable(getResources().getDrawable(R.drawable.dot_white));
            mDot[currentIndex].setImageDrawable(getResources().getDrawable(R.drawable.dot_gray));
            currentIndex = positon;
        }
    }

    //固定要執行的方法
    private Runnable updateTimer = new Runnable() {
        public void run() {
//            L.d(TAG,"updateTimer");
//            if(!isAdded()){
//                L.i(TAG ,"updateTimer UI but activity isn't exist.");
//                return;
//            }
            int nextItemIndex = mViewPager.getCurrentItem()+1;
            mViewPager.setCurrentItem(nextItemIndex);
//            setCurDot(nextItemIndex % mViewPagerAdapter.getOriginalCount());
            //設定定時要執行的方法
            handler.removeCallbacks(updateTimer);
            //設定Delay的時間
            handler.postDelayed(updateTimer, IMAGE_DELAYDE);
        }
    };
}
