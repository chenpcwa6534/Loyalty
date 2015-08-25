package friendo.mtel.loyalty.activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.page.sliding.PagerSlidingTabStrip;
import com.astuetz.utility.PicassoUtility;

import java.util.ArrayList;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.StoreInfoFragment;
import friendo.mtel.loyalty.adapter.TabPageAdapter;
import friendo.mtel.loyalty.components.FirmInfoData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;
import friendo.mtel.loyalty.fragment.PointFragment;
import friendo.mtel.loyalty.fragment.PreferentialFragment;
import friendo.mtel.loyalty.fragment.StorePreferentialFragmemt;
import friendo.mtel.loyalty.utility.UtilityInitial;

/**
 * Created by MTel on 2015/7/28.
 */
public class SubFrontPageActivity extends CommonActionBarActivity implements View.OnClickListener{
    private String TAG = SubFrontPageActivity.class.getSimpleName();

    private View mToolsbar;
    private TextView mToolsbarTitle;
    private ImageView mBack;
    private ImageView mMessage;
    private TextView mMessageQTY;
    private ImageView mPartner;

    private PagerSlidingTabStrip mTab;
    private ViewPager mPage;
    private ArrayList<Fragment> pages;

    private int db_firmID;
    private String db_firmName;
    private String db_picture;
    private String db_partnerMessage;
    private boolean db_ispartner;

    private ImageView mStorePicture;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subfrontpage);
        findView();
        if(initData()){
            db_firmID = savedInstanceState.getInt("firmID");
            db_firmName = savedInstanceState.getString("firmName");
            db_picture = savedInstanceState.getString("picture");
            db_ispartner = savedInstanceState.getBoolean("partner");
            db_partnerMessage = savedInstanceState.getString("partnermessage");
        }
        initView();
        initTabView();
        initPagerView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("firmID", db_firmID);
        outState.putString("firmName",db_firmName);
        outState.putString("picture", db_picture);
        outState.putString("partnermessage",db_partnerMessage);
        outState.putBoolean("partner", db_ispartner);
    }

    private Boolean initData(){
       if(getIntent().getExtras() != null){
           db_firmID = getIntent().getExtras().getInt("firmID");
           db_firmName = getIntent().getExtras().getString("firmName");
           db_picture = getIntent().getExtras().getString("picture");
           db_ispartner = getIntent().getExtras().getBoolean("partner");
           db_partnerMessage = getIntent().getExtras().getString("partnermessage");
           return false;
       }else{
           return true;
       }
        //DataManager.getInstance(this).qryFirmInfoData(this, String.valueOf(db_firmID), true, getDataResponse);

    }

    private void findView(){
        mToolsbar = (View) findViewById(R.id.toolbar);
        mToolsbarTitle = (TextView) mToolsbar.findViewById(R.id.txt_title);
        mBack = (ImageView) mToolsbar.findViewById(R.id.img_back);
        mMessage = (ImageView) mToolsbar.findViewById(R.id.img_message);
        mMessageQTY = (TextView) mToolsbar.findViewById(R.id.img_messageQTY);

        mTab = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mPage = (ViewPager) findViewById(R.id.pager);

        mStorePicture = (ImageView) findViewById(R.id.img_StorePicture);
        mPartner = (ImageView) findViewById(R.id.img_partner);

        mBack.setOnClickListener(this);
        mPartner.setOnClickListener(this);

        if(db_ispartner){
            mPartner.setVisibility(View.VISIBLE);
        }
    }

    private void initView(){
        mToolsbarTitle.setText(db_firmName);
        PicassoUtility.load(this,mStorePicture,db_picture);
    }

    private void initPagerView(){
        TabPageAdapter tabPageAdapter = new TabPageAdapter(getSupportFragmentManager(),pages);
        tabPageAdapter.setTabTitle(UtilityInitial.frontTabTitle(this));
        tabPageAdapter.setTextColor(getResources().getColor(R.color.white), getResources().getColor(R.color.str_orange));
        tabPageAdapter.setBackground(R.mipmap.btn_common_white_kind_pressed);

        mPage.setOffscreenPageLimit(pages.size());
        mPage.setAdapter(tabPageAdapter);

        mTab.setTabBackground(R.drawable.tab_background_sub);
        mTab.setViewPager(mPage);
    }

    private void initTabView(){
        StorePreferentialFragmemt storePreferentialFragmemt = StorePreferentialFragmemt.newInstance(db_firmID,db_firmName);
        PointFragment pointFragment = PointFragment.newInstance(db_firmID,db_firmName);
        StoreInfoFragment storeInfoFragment = StoreInfoFragment.newInstance(db_firmID);

        pages = new ArrayList<Fragment>();
        pages.add(storePreferentialFragmemt);
        pages.add(pointFragment);
        pages.add(storeInfoFragment);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                finish();
                break;
            case R.id.img_partner:
                break;
        }
    }
}
