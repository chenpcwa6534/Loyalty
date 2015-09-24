package friendo.mtel.loyalty.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.astuetz.page.sliding.PagerSlidingTabStrip;

import java.util.ArrayList;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.adapter.TabPageAdapter;
import friendo.mtel.loyalty.data.DataCache;
import friendo.mtel.loyalty.fragment.FrontPageFragment;
import friendo.mtel.loyalty.fragment.MoreFragment;
import friendo.mtel.loyalty.fragment.PocketFragment;
import friendo.mtel.loyalty.fragment.PreferentialFragment;
import friendo.mtel.loyalty.utility.UtilityInitial;

/**
 * Created by MTel on 2015/7/24.
 */
public class MainActivity extends CommonActionBarActivity {
    private String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private PagerSlidingTabStrip mTab;
    private ViewPager mPage;
    private ArrayList<Fragment> pages;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void findView(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTab = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mPage = (ViewPager) findViewById(R.id.pager);
    }

    private void initView(){
        initToolbar();
        initTabView();
        initPagerView();
    }

    private void initToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView title = (TextView) mToolbar.findViewById(R.id.toolbar_title);
        View message = (View) mToolbar.findViewById(R.id.toolbar_message);
        TextView qty = (TextView) mToolbar.findViewById(R.id.toolbar_messageQTY);
        title.setText(getString(R.string.applicationName));
    }

    private void initPagerView(){
        mTab = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mPage = (ViewPager) findViewById(R.id.pager);

        TabPageAdapter tabPageAdapter = new TabPageAdapter(getSupportFragmentManager(),pages);
        tabPageAdapter.setTabTitle(UtilityInitial.tabTitle(this));
        tabPageAdapter.setTabIcon(UtilityInitial.tabIcon_press);
        tabPageAdapter.setTabIconPress(UtilityInitial.tabIcon_pressed);
        tabPageAdapter.setBackground(R.mipmap.btn_common_red_category_pressed);
        tabPageAdapter.setTextColor(getResources().getColor(R.color.white),getResources().getColor(R.color.red));

        mPage.setOffscreenPageLimit(pages.size());
        mPage.setAdapter(tabPageAdapter);

        mTab.setViewPager(mPage);
    }

    private void initTabView(){
        //集點店家
        FrontPageFragment frontPageFragment = new FrontPageFragment();
        //Fragment frontPageFragment = new Fragment();
        //限量優惠卷
        PreferentialFragment preferentialpage = new PreferentialFragment();
        //我的口袋
        PocketFragment pocketpage = new PocketFragment();
        //更多
        MoreFragment morepage = new MoreFragment();

        pages = new ArrayList<Fragment>();
        pages.add(frontPageFragment);
        pages.add(preferentialpage);
        pages.add(pocketpage);
        pages.add(morepage);
    }
}
