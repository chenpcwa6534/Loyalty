package friendo.mtel.loyalty.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.webkit.JavascriptInterface;

import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.component.FirmInfoData;
import friendo.mtel.loyalty.component.FirmListData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;
import friendo.mtel.loyalty.utility.Utilitys;
import friendo.mtel.loyalty.view.WebMapJSInterface;

/**
 * Created by MTel on 2015/8/4.
 */
public class StoreInfoFragment extends CommonFragment implements ImageButton.OnClickListener{
    private String TAG = StoreInfoFragment.class.getSimpleName();

    private FirmInfoData db_frimInfo;

    private ImageButton mBeaconControl;
    private TextView mIntroductio;
    private WebMapJSInterface mMap;
    private TextView mAddress;
    private TextView mTel;
    private LinearLayout mBusinessTime;
    private TextView mBus;
    private TextView mPark;
    private TextView mWeb;
    private LinearLayout mLink;
    private TextView mBlog;

    private FirmListData db_firmData;


    private double Location_LAT = 0;
    private double Location_LNG = 0;

    int beaconIcon_Close = R.mipmap.btn_common_gary_close;
    int beaconIcon_Open = R.mipmap.btn_common_orange_open;
    //test
    boolean  beaconstatus = false;


    public static StoreInfoFragment newInstance(FirmListData firmData){
        StoreInfoFragment storeInfoFragment = new StoreInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("value", firmData);
        storeInfoFragment.setArguments(bundle);
        return storeInfoFragment;
    }

    public StoreInfoFragment() {
        super();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_storeinfo,container,false);
        findView(v);
        initData();
        return v;
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgbtn_beaconcontrol:
                BeaconControl();
                break;
            case R.id.txt_blog:
                intentGoogleSearch(db_frimInfo.getBlogConnnent());
                break;
            case R.id.txt_address:
                intentMap(db_frimInfo.getAddress());
                break;
        }
    }


    private void findView(View v){
        mBeaconControl = (ImageButton) v.findViewById(R.id.imgbtn_beaconcontrol);
        mIntroductio = (TextView) v.findViewById(R.id.txt_introduction);
        mMap = (WebMapJSInterface) v.findViewById(R.id.web_map);

        mAddress = (TextView) v.findViewById(R.id.txt_address);
        mTel = (TextView) v.findViewById(R.id.txt_tel);
        mBusinessTime = (LinearLayout) v.findViewById(R.id.weekView);
        mBus = (TextView) v.findViewById(R.id.txt_bus);
        mPark = (TextView) v.findViewById(R.id.txt_park);
        mWeb = (TextView) v.findViewById(R.id.txt_web);
        mLink = (LinearLayout) v.findViewById(R.id.linkView);
        mBlog = (TextView) v.findViewById(R.id.txt_blog);
    }

    private void initData(){
        db_firmData = (FirmListData) getArguments().getSerializable("value");
        DataManager.getInstance(getActivity()).qryFirmInfo(db_firmData.getFirm_id(),getDataResponse);
    }

    private void initView(FirmInfoData data){
        mBeaconControl.setBackgroundResource(beaconstatus ? beaconIcon_Open : beaconIcon_Close);
        mBeaconControl.setOnClickListener(this);
        mBlog.setOnClickListener(this);
        mAddress.setOnClickListener(this);

        mMap.addLocation(db_firmData.getLatitude(), db_firmData.getLongitude());
        mMap.locateMap();

        mIntroductio.setText("");
        mAddress.setText(data.getAddress());
        mTel.setText(data.getFirm_tel());
        setBusinessTime(data.getBusiness_week());
        mBus.setText(data.getTraffic());
        mPark.setText(data.getCarpark());
        setWebLink(data.getWebUrl());
    }

    private void setBusinessTime(String[] businessTime){

        for(int i=0; i<businessTime.length; i++){
            TextView businessList = new TextView(getActivity());
            businessList.setText(businessTime[i]);
            if(Utilitys.getTodayWeekDay(i)){
                businessList.setTextColor(getActivity().getResources().getColor(R.color.red));
            }else{
                businessList.setTextColor(getActivity().getResources().getColor(R.color.str_infor));
            }
            businessList.setLayoutParams(getParmas());
            mBusinessTime.addView(businessList);
        }
    }

    private void setWebLink(String[] link){
        for(int i=0; i<link.length; i++){
            if(i == 0){
                mWeb.setText(link[i]);
            }else{
                TextView linktext = new TextView(getActivity());
                linktext.setText(link[i]);
                linktext.setTextColor(getActivity().getResources().getColor(R.color.str_infor));
                linktext.setLayoutParams(getParmas());
                linktext.setAutoLinkMask(Linkify.WEB_URLS);
                mLink.addView(linktext);
            }
        }
    }

    private LayoutParams getParmas(){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        params.setMargins(0, Utilitys.dpToPx(10), 0, 0);
        return params;
    }


    private void BeaconControl(){
        if(beaconstatus){
            mBeaconControl.setBackgroundResource(beaconIcon_Close);
            beaconstatus = false;
        }else{
            mBeaconControl.setBackgroundResource(beaconIcon_Open);
            beaconstatus = true;
        }
    }

    private GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {

        }

        @Override
        public void onSuccess(Object obj) {
            FirmInfoData firmInfoData = (FirmInfoData) obj;
            db_frimInfo = firmInfoData;
            initView(firmInfoData);
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
}
