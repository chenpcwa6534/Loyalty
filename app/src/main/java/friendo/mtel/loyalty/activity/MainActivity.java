package friendo.mtel.loyalty.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.astuetz.PagerSlidingBanner;
import com.astuetz.PagerSlidingTabStrip;

import java.util.ArrayList;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.adapter.TabPageAdapter;
import friendo.mtel.loyalty.fragment.MoreFragment;
import friendo.mtel.loyalty.fragment.PocketFragment;
import friendo.mtel.loyalty.fragment.PreferentialFragment;
import friendo.mtel.loyalty.fragment.StoreFragment;


public class MainActivity extends ActionBarActivity {
    private String TAG = MainActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private PagerSlidingTabStrip mTab;
    private ViewPager mPage;

    private String db_MessageQTY;
    private boolean db_Isfirst = true;


    private String[] toppings;
    private int[] toppingIcons;
    private int[] toppingIconsPress;
    private ArrayList<Fragment> pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initToolbar();
        initTab();

    }

    private void initData(){
        db_MessageQTY = "3";
        toppings = new String[]{getString(R.string.store), getString(R.string.preferential), getString(R.string.pocket), getString(R.string.more)};
        toppingIcons = new int[]{R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher,R.mipmap.ic_launcher};
        toppingIconsPress = new int[]{R.mipmap.ic_message,R.mipmap.ic_message,R.mipmap.ic_message,R.mipmap.ic_message};
    }

    private void initToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        TextView title = (TextView) mToolbar.findViewById(R.id.toolbar_title);
        View message = (View) mToolbar.findViewById(R.id.toolbar_message);
        TextView qty = (TextView) mToolbar.findViewById(R.id.toolbar_messageQTY);

        title.setText(getString(R.string.applicationName));
        if(Integer.valueOf(db_MessageQTY) != 0){
            qty.setText(db_MessageQTY);
            qty.setVisibility(View.VISIBLE);
        }

    }

    private void initTab(){
        initFragmentPager();
        mTab = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mPage = (ViewPager) findViewById(R.id.pager);

        TabPageAdapter tabPageAdapter = new TabPageAdapter(getSupportFragmentManager(),pages);
        tabPageAdapter.setTabTitle(toppings);
        tabPageAdapter.setTabIcon(toppingIcons);
        tabPageAdapter.setTabIconPress(toppingIconsPress);

        mPage.setOffscreenPageLimit(pages.size());
        mPage.setAdapter(tabPageAdapter);

        mTab.setViewPager(mPage);
    }

    private void initFragmentPager(){
        StoreFragment storepage = new StoreFragment();
        PreferentialFragment preferentialpage = new PreferentialFragment();
        PocketFragment pocketpage = new PocketFragment();
        MoreFragment morepage = new MoreFragment();

        pages = new ArrayList<Fragment>();
        pages.add(storepage);
        pages.add(preferentialpage);
        pages.add(pocketpage);
        pages.add(morepage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
