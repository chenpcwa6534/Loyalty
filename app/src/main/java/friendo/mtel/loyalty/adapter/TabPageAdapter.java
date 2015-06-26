package friendo.mtel.loyalty.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

/**
 * Created by MTel on 2015/6/24.
 */
public class TabPageAdapter extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
    private static String TAG = TabPageAdapter.class.getSimpleName();

    private ArrayList<Fragment> mPages;
    private String[] mTitle;
    private int[] mIcon;
    private int[] mIcon_press;
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

    @Override
    public int getPageIconResId(int position) {
        return mIcon[position];
    }

    @Override
    public int getPageIconPressResId(int position) {
        return mIcon_press[position];
    }
}
