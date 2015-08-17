package com.astuetz.com.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by MTel on 2015/6/26.
 */
public class BannerAdapter  extends PagerAdapter{

    private String TAG = BannerAdapter.class.getSimpleName();

    private Context mContext;
    private ArrayList<Object> pages;
    private View.OnClickListener listener;

    public BannerAdapter(Context context, ArrayList<Object> page, View.OnClickListener listener) {
        super();
        this.mContext = context;
        this.pages = page;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return pages.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }

    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }
}
