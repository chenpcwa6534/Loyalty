package friendo.mtel.loyalty;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;
import android.webkit.JavascriptInterface;

import friendo.mtel.loyalty.components.FirmInfoData;
import friendo.mtel.loyalty.data.DataCache;
import friendo.mtel.loyalty.fragment.CommonFragment;
import friendo.mtel.loyalty.utility.Utilitys;

/**
 * Created by MTel on 2015/8/4.
 */
public class StoreInfoFragment extends CommonFragment implements ImageButton.OnClickListener{
    private String TAG = StoreInfoFragment.class.getSimpleName();

    private FirmInfoData db_frimInfo;

    private ImageButton mBeaconControl;
    private TextView mIntroductio;
    private WebView mMap;
    private TextView mAddress;
    private TextView mTel;
    private TextView mBusinessTime;
    private TextView mBus;
    private TextView mPark;
    private TextView mWeb;
    private TextView mLink;
    private TextView mBlog;

    int beaconIcon_Close = R.mipmap.btn_common_gary_close;
    int beaconIcon_Open = R.mipmap.btn_common_orange_open;
    //test
    boolean  beaconstatus = false;

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
        db_frimInfo = DataCache.cacheFirmInfoData;
        findView(v);
        initView();
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
                intentGoogleSearch(db_frimInfo.getFirm_name());
                break;
            case R.id.txt_address:
                intentMap(db_frimInfo.getAddress());
                break;
        }
    }


    private void findView(View v){
        mBeaconControl = (ImageButton) v.findViewById(R.id.imgbtn_beaconcontrol);
        mIntroductio = (TextView) v.findViewById(R.id.txt_introduction);
        mMap = (WebView) v.findViewById(R.id.web_map);

        mAddress = (TextView) v.findViewById(R.id.txt_address);
        mTel = (TextView) v.findViewById(R.id.txt_tel);
        mBusinessTime = (TextView) v.findViewById(R.id.txt_businesstime);
        mBus = (TextView) v.findViewById(R.id.txt_bus);
        mPark = (TextView) v.findViewById(R.id.txt_park);
        mWeb = (TextView) v.findViewById(R.id.txt_web);
        mLink = (TextView) v.findViewById(R.id.txt_link);
        mBlog = (TextView) v.findViewById(R.id.txt_blog);
    }

    private void initView(){
        mBeaconControl.setBackgroundResource(beaconstatus ? beaconIcon_Open : beaconIcon_Close);
        mBeaconControl.setOnClickListener(this);
        mBlog.setOnClickListener(this);
        mAddress.setOnClickListener(this);

        mIntroductio.setText(db_frimInfo.getDescription());
        mAddress.setText(db_frimInfo.getAddress());
        mTel.setText(db_frimInfo.getTel());
        mBusinessTime.setText(db_frimInfo.getOpenhours_remark());
        mBus.setText(db_frimInfo.getTraffic());
        mPark.setText(db_frimInfo.getParking());
        mWeb.setText(db_frimInfo.getOfficial_site());
        mLink.setText("");

        mMap.setWebViewClient(new WebViewClient());
        mMap.getSettings().setJavaScriptEnabled(true);
//        mMap.addJavascriptInterface(getActivity(), "AndroidFunction")
        mMap.loadUrl("file:///android_asset/index.html");
    }

    @JavascriptInterface
    public double getLat(){ //上面記得要打JavascriptInterface

        return Utilitys.getLocation(getActivity()).getLatitude();
    }
    @JavascriptInterface
    public double getLng(){
        return Utilitys.getLocation(getActivity()).getLongitude();
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
}
