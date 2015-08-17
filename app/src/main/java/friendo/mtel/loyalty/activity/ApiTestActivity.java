package friendo.mtel.loyalty.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import friendo.mtel.loyalty.HttpsParams.ParamsManager;
import friendo.mtel.loyalty.R;
import friendo.mtel.loyalty.components.FilterData;
import friendo.mtel.loyalty.HttpsParams.FrontPageInParams;
import friendo.mtel.loyalty.components.FrontPageRTNData;
import friendo.mtel.loyalty.data.DataManager;
import friendo.mtel.loyalty.data.GetDataResponse;

/**
 * Created by MTel on 2015/7/17.
 */
public class ApiTestActivity extends Activity implements View.OnClickListener{

    private TextView mApiFilter;
    private TextView mApiMemberCoupon;
    private TextView mApiFrontPageRTN;


    private TextView mApiContent;
    private TextView mApiStatus;

    private LinearLayout mApiContextView;

    private String ApiName;

    //Test data
    int CatID = 1;
    String memberID = "62a714dd-987d-46ec-80f3-a14072a21ed1";
    String deviceToken = "ABC";
    String firmID = "12";
    String latitude = "25.00000";
    String longitude = "10.2414";
    String distance = "30";
    String allotID = "12";
    String page = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apitest);
        initFindView();
    }

    @Override
    public void onClick(View v) {
        Gson gson = new Gson();
        mApiStatus.setText("");
        mApiContextView.removeAllViews();
        switch (v.getId()){
            case R.id.txt_apiFrontPageRTN:
                 //store api need catid
                ApiName = "FrontPage RTN";
                FrontPageInParams frontPageInParams = ParamsManager.getfrontPageInParams("", "", "", 0, 0, 2, "", 0);

                String userFilter = gson.toJson(frontPageInParams);
                DataManager.getInstance(this).qryFrontPageRTNData(this, memberID, deviceToken, page, userFilter, false, getDataResponse);
                break;
            case R.id.txt_apiFilter:
                ApiName = "Filter";
                DataManager.getInstance(this).qryFilterData(this, true, getDataResponse);
                break;
            case R.id.txt_apiMemberCoupon:
                ApiName = "MemberCouponsData";
                DataManager.getInstance(this).qryMemberCouponsData(this,true,getDataResponse);
                break;
        }
    }

    private void initFindView(){
        mApiFilter = (TextView) findViewById(R.id.txt_apiFilter);
        mApiMemberCoupon = (TextView) findViewById(R.id.txt_apiMemberCoupon);
        mApiFrontPageRTN = (TextView) findViewById(R.id.txt_apiFrontPageRTN);

        mApiContent = (TextView) findViewById(R.id.txt_api);
        mApiStatus = (TextView) findViewById(R.id.txt_apiStauts);
        mApiContextView = (LinearLayout) findViewById(R.id.ly_apiContent);

        mApiFilter.setOnClickListener(this);
        mApiMemberCoupon.setOnClickListener(this);
        mApiFrontPageRTN.setOnClickListener(this);
    }

    private void showApi(Object obj){

        if(obj instanceof FilterData){
            FilterData filterData = (FilterData) obj;
            showStoreTypeData(filterData);
        }else if (obj instanceof FrontPageRTNData){
            FrontPageRTNData frontPageRTNData = (FrontPageRTNData) obj;
            showFrontPageRTNData(frontPageRTNData);
        }
    }

    private void newTextView(String str){
        TextView textView = new TextView(this);
        textView.setText(str);
        mApiContextView.addView(textView);
    }

    private void showApi(Object[] obj){

    }

    GetDataResponse getDataResponse = new GetDataResponse() {
        @Override
        public void onStart() {
            mApiStatus.setText("Call Api OnStart");
        }

        @Override
        public void onSuccess(Object obj) {
            mApiStatus.setText("Call Api onSuccess");
            showApi(obj);
        }

        @Override
        public void onSuccess(Object[] obj) {
            mApiStatus.setText("Call Api onSuccess");
        }

        @Override
        public void onFailure(Object obj) {
            mApiStatus.setText("Call Api onFailure : "+obj);
        }

        @Override
        public void onFinish() {
            mApiStatus.setText("Call Api onFinish");
        }
    };





    private void showStoreTypeData(FilterData data){
        for(int i=0; i< data.getAreas().length; i++){
            String strApi = "api item : " + i + "===> CityName : " + data.getAreas()[i].getCity_name() + " , CityID : " + data.getAreas()[i].getCity_id()+"\n";
            if(i == 0){
                newTextView("ads \n -----------"+strApi);
            }else{
                newTextView(strApi);
            }
            for(int j=0; j<data.getAreas()[i].getSubareas().length; j++){
                String subAreastrApi = "=======> item : " +j+ "  ,subAreaID : "+ data.getAreas()[i].getSubareas()[j].getSubarea_id() +"  ,subAreaName : "+data.getAreas()[i].getSubareas()[j].getSubarea_name();
                newTextView(subAreastrApi);
            }
        }

        for(int i=0; i< data.getCats().length; i++){
            String strApi = "api item : " + i + "===> CatID : " + data.getCats()[i].getCat_id() + " , CatName : " + data.getCats()[i].getCat_name() +"\n";
            if(i == 0){
                newTextView("cats \n -----------"+strApi);
            }else{
                newTextView(strApi);
            }
            for(int j=0; j<data.getCats()[i].getSubcats().length; j++){
                String subAreastrApi = "=======> item : " +j+ "  ,subCatID : "+ data.getCats()[i].getSubcats()[j].getSubcat_id() +"  ,subCatName : "+data.getCats()[i].getSubcats()[j].getSubcat_name();
                newTextView(subAreastrApi);
            }
        }

        for(int i=0; i< data.getOrders().length; i++){
            String strApi = "api item : " + i + "===> OrderID : " + data.getOrders()[i].getOrder_id() + " , OrderName : " + data.getOrders()[i].getOrder_name() +"\n";
            if(i == 0){
                newTextView("order \n -----------"+strApi);
            }else{
                newTextView(strApi);
            }
        }
    }

    private void showFrontPageRTNData(FrontPageRTNData data){

    }
}
