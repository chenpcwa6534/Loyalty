package com.astuetz.com.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.astuetz.pagerslidingtabstrip.R;

import java.util.ArrayList;

/**
 * Created by MTel on 2015/6/29.
 */
public class ViewPagerAdapter extends PagerAdapter implements View.OnClickListener{

    private String TAG = ViewPagerAdapter.class.getSimpleName();

    private Context mContext;
    private ArrayList<View> data;
    private ViewpageCallback listener;
    private boolean isLoop = false;

    public ViewPagerAdapter(Context context, ArrayList<View> data, ViewpageCallback listener){
        this.mContext = context;
        this.listener = listener;
        this.data = data;
    }

    public int getOriginalCount(){
        return data.size();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View page = data.get(position);
        if(page instanceof ImageView){
            ImageView imageView = (ImageView) page;
            imageView.setOnClickListener(this);
            imageView.setId(position);
            ((ViewPager) container).addView(imageView);
            return imageView;
        }else if(page instanceof VideoView){
            VideoView videoView = (VideoView) page;
            ((ViewPager) container).addView(videoView);
            return videoView;
        }
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }

    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }

    @Override
    public void onClick(View v) {
        listener.onClick((int) v.getId());
    }

    public interface ViewpageCallback{
        void onClick(int position);
    }
}
