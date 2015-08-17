package friendo.mtel.loyalty.adapter;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.astuetz.page.sliding.PagerSlidingTabStrip;

import java.util.ArrayList;

import friendo.mtel.loyalty.R;

/**
 * Created by MTel on 2015/6/24.
 */
public class TabPageAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
    private static String TAG = TabPageAdapter.class.getSimpleName();

    private ArrayList<Fragment> mPages;
    private String[] mTitle;
    private int[] mIcon;
    private int[] mIcon_press;
    private int mText_press;
    private int mText_pressed;
    private int mBackground;
    public TabPageAdapter(FragmentManager fm, ArrayList<Fragment> pages) {
        super(fm);
        this.mPages = pages;
    }

    @Override
    public Fragment getItem(int position) {
        return mPages.get(position);
    }

    @Override
    public int getCount() {
        return mPages.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(mTitle.length > position){
            return mTitle[position];
        }else{
            return "";
        }
    }

    public void setTabTitle(String[] title){
        this.mTitle = title;
    }

    public void setTabIcon(int[] icon){
        this.mIcon = icon;
    }

    public void setTabIconPress(int[] icon){
        this.mIcon_press = icon;
    }

    public void setTextColor(int textpress, int textpressed){
        this.mText_press = textpress;
        this.mText_pressed = textpressed;
    }

    public void setBackground(int backgroundDrawable){
        this.mBackground = backgroundDrawable;
    }

    @Override
    public int getPageIconResId(int position) {
        if(mIcon == null){
            return 0;
        }else {
            return mIcon[position];
        }
    }

    @Override
    public int getPageIconPressResId(int position) {
        if(mIcon_press == null){
            return 0;
        }else {
            return mIcon_press[position];
        }
    }

    @Override
    public int getTextColorPress() {
        return mText_press;
    }

    @Override
    public int getTextColorPressed() {
        return mText_pressed;
    }

    @Override
    public int getBackgroundPress() {
        if(mBackground != 0){
            return mBackground;
        }else{
            return 0;
        }
    }
}
