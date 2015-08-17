package friendo.mtel.loyalty.activity;

import android.content.Intent;
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

    private PagerSlidingTabStrip mTab;
    private ViewPager mPage;
    private ArrayList<Fragment> pages;
    private int db_firmID;

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
        initData();
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

    private void initData(){
        db_firmID = getIntent().getExtras().getInt("firmID");
        DataManager.getInstance(this).qryFirmInfoData(this, String.valueOf(db_firmID), true, getDataResponse);
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

        mBack.setOnClickListener(this);
    }

    private void initView(FirmInfoData data){
        mToolsbarTitle.setText(data.getFirm_name());
        PicassoUtility.load(this,mStorePicture,data.getPicture());
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
        StorePreferentialFragmemt storePreferentialFragmemt = StorePreferentialFragmemt.newInstance(db_firmID);
        PointFragment pointFragment = PointFragment.newInstance(db_firmID);
        StoreInfoFragment storeInfoFragment = new StoreInfoFragment();

        pages = new ArrayList<Fragment>();
        pages.add(storePreferentialFragmemt);
        pages.add(pointFragment);
        pages.add(storeInfoFragment);
    }

    private GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {
            FirmInfoData firmInfoData = (FirmInfoData) obj;
            initView(firmInfoData);
            initTabView();
            initPagerView();
        }

        @Override
        public void onSuccess(Object[] obj) {

        }

        @Override
        public void onFailure(Object obj) {

        }

        @Override
        public void onFinish() {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                finish();
                break;
        }
    }
}
