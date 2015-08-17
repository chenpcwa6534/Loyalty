package friendo.mtel.loyalty.httpapi;


import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import friendo.mtel.loyalty.HttpsParams.FrontPageInParams;
import friendo.mtel.loyalty.TestDataJson.TestDataJson;
import friendo.mtel.loyalty.common.Env;
import friendo.mtel.loyalty.components.DeluxeCoupon;
import friendo.mtel.loyalty.components.FilterData;
import friendo.mtel.loyalty.components.FirmInfoData;
import friendo.mtel.loyalty.components.FrontPageRTNData;
import friendo.mtel.loyalty.components.MemberCouponsData;
import friendo.mtel.loyalty.components.MemberLoyaltyData;
import friendo.mtel.loyalty.components.MemberPointData;
import friendo.mtel.loyalty.components.MyCouponData;
import friendo.mtel.loyalty.components.Test;
import friendo.mtel.loyalty.view.ConditionsSearchView;

/**
 * Created by MTel on 2015/7/16.
 */
public class HTTPApi {
    static String TAG = HTTPApi.class.getSimpleName();


    /**
     * 版本相關
     * @param context
     * @param verUpdateTime
     * @param body
     * @param callAPIResponse
     */
    public void qryVersionControl(Context context, String memberID , String verUpdateTime, String body ,final CallAPIResponse callAPIResponse){
        String apiName = "";
        final JSONObject jsonObject = new JSONObject();

//        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){
//
//            @Override
//            public void onStart() {
//                Log.i(TAG,"qryFilter onStart");
//            }
//
//            @Override
//            public void onFinish() {
//                Log.i(TAG,"qryFilter onFinish");
//            }
//
//            @Override
//            public void onFailure(String msg) {
//                Log.i(TAG,"qryFilter onFailure msg:" +msg);
//            }
//
//            @Override
//            public void onSuccess(JSONObject response) {
//                Log.i(TAG, "qryFilter onSuccess=" + response);
//                try {
//                    String data = response.getString("data");
//                    Gson gson = new Gson();
//
//                    if(callAPIResponse != null) callAPIResponse.onSuccess(filterData);
//
//                }catch (Exception e) {
//                    Log.e(TAG, e.getMessage());
//                }
//            }
//        });

        if(getResult(TestDataJson.getVersionControlResponseData())){
            String data = getData(TestDataJson.getVersionControlResponseData());
            if(callAPIResponse != null){
                callAPIResponse.onSuccess(data);
            }
        }else{
            if(callAPIResponse != null){
                callAPIResponse.onFailure(getError(context,TestDataJson.getResponseError()));
            }
        }
    }


    public void qryAskOTP(Context context, String number,final CallAPIResponse callAPIResponse){
        String apiName = "";
        final JSONObject jsonObject = new JSONObject();

//        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){
//
//            @Override
//            public void onStart() {
//                Log.i(TAG,"qryFilter onStart");
//            }
//
//            @Override
//            public void onFinish() {
//                Log.i(TAG,"qryFilter onFinish");
//            }
//
//            @Override
//            public void onFailure(String msg) {
//                Log.i(TAG,"qryFilter onFailure msg:" +msg);
//            }
//
//            @Override
//            public void onSuccess(JSONObject response) {
//                Log.i(TAG, "qryFilter onSuccess=" + response);
//                try {
//                    String data = response.getString("data");
//                    Gson gson = new Gson();
//
//                    if(callAPIResponse != null) callAPIResponse.onSuccess(filterData);
//
//                }catch (Exception e) {
//                    Log.e(TAG, e.getMessage());
//                }
//            }
//        });


        if(getResult(TestDataJson.getAskOTPResponseData())){
            if(callAPIResponse != null){
                callAPIResponse.onSuccess(number);
            }
        }else{
            if(callAPIResponse != null){
                callAPIResponse.onFailure(getError(context,TestDataJson.getResponseError()));
            }
        }
    }



    public void qryVerificationOTP(Context context, String number, String VerificationCode, String deviceToken ,final CallAPIResponse callAPIResponse){
        String apiName = "";
        final JSONObject jsonObject = new JSONObject();

//        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){
//
//            @Override
//            public void onStart() {
//                Log.i(TAG,"qryFilter onStart");
//            }
//
//            @Override
//            public void onFinish() {
//                Log.i(TAG,"qryFilter onFinish");
//            }
//
//            @Override
//            public void onFailure(String msg) {
//                Log.i(TAG,"qryFilter onFailure msg:" +msg);
//            }
//
//            @Override
//            public void onSuccess(JSONObject response) {
//                Log.i(TAG, "qryFilter onSuccess=" + response);
//                try {
//                    String data = response.getString("data");
//                    Gson gson = new Gson();
//
//                    if(callAPIResponse != null) callAPIResponse.onSuccess(filterData);
//
//                }catch (Exception e) {
//                    Log.e(TAG, e.getMessage());
//                }
//            }
//        });

        if(getResult(TestDataJson.getVerificationCodeResponseData())){
            String data = getData(TestDataJson.getVerificationCodeResponseData());
            if(callAPIResponse != null){
                callAPIResponse.onSuccess(data);
            }
        }else{
            if(callAPIResponse != null){
                callAPIResponse.onFailure(getError(context,TestDataJson.getResponseError()));
            }
        }
    }






    private boolean getResult(JSONObject response){
        boolean result = false;
        try {
            result = response.getBoolean("result");
        }catch (Exception e){
            Log.e(TAG,"result have wrong ,JSON to boolean is fail , data is [" + response.toString()+"]");
        }
        return result;
    }


    private String getError(Context context, JSONObject response){
        String msg = "";
        try{
            int errorCode = response.getInt("errorCode");
            msg = HttpErrorMessage.getInstance(context).errorMessage(errorCode);
        }catch (Exception e){
            Log.e(TAG,"ErrorCode have wrong ,JSON to String is fail , data is [" + response.toString()+"]");
        }
        return msg;
    }

    private String getData(JSONObject response){
        String data = "";
        try{
            data = response.getString("data");
        }catch (Exception e){
            Log.e(TAG,"data have wrong ,JSON to String is fail , data is [" + response.toString()+"]");
        }
        return data;
    }

    private String[] getArrayData(JSONObject response){
        String[] data= null;
        try{
            JSONArray jsonArray = response.getJSONArray("data");
             data = new String[jsonArray.length()];
            for(int i=0; i<jsonArray.length(); i++){
                data[i] = jsonArray.getString(i).toString();
            }
        }catch (Exception e){
            Log.e(TAG,"data array have wrong ,JSON to String is fail , data is [" + response.toString()+"]");
        }
        return data;
    }

    //=====================================================//==========================================================================================================
    //  old api


    public void qryFilter(Context context, final CallAPIResponse callAPIResponse){
        String apiName = "stamps/ui/filter";
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryFilter onStart");
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryFilter onFinish");
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryFilter onFailure msg:" +msg);
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryFilter onSuccess=" + response);
                try {
                    String data = response.getString("data");
                    Gson gson = new Gson();
                    FilterData filterData = gson.fromJson(data,FilterData.class) ;
                    if(callAPIResponse != null) callAPIResponse.onSuccess(filterData);

                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }


    public void qryMemberCoupons(Context context, String memberID, String device_token, final CallAPIResponse callAPIResponse){
        String apiName = "stamps/members/"+memberID+"/my-coupons/"+device_token;
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryMemberCoupons onStart");
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryMemberCoupons onFinish");
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryMemberCoupons onFailure msg:" +msg);
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryMemberCoupons onSuccess=" + response);
                try {
                    JSONArray data = response.getJSONArray("data");
                    Gson gson = new Gson();
                    MemberCouponsData[] memberCouponsDatas = new MemberCouponsData[data.length()];
                    for(int i=0; i<data.length(); i++){
                        memberCouponsDatas[i] = gson.fromJson(data.getString(i),MemberCouponsData.class);
                    }
                    if(callAPIResponse != null) callAPIResponse.onSuccess(memberCouponsDatas);

                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }

    public void qryMemberLoyalty(Context context, String memberID, final CallAPIResponse callAPIResponse){
        String apiName = "stamps/members/"+memberID+"/MemberLoyalty";
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryMemberLoyalty onStart");
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryMemberLoyalty onFinish");
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryMemberLoyalty onFailure msg:" +msg);
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryMemberLoyalty onSuccess=" + response);
                try {
                    JSONArray data = response.getJSONArray("data");
                    Gson gson = new Gson();
                    MemberLoyaltyData[] memberLoyaltyDatas = new MemberLoyaltyData[data.length()];
                    for(int i=0; i<data.length(); i++){
                        memberLoyaltyDatas[i] = gson.fromJson(data.getString(i),MemberLoyaltyData.class);
                    }
                    if(callAPIResponse != null) callAPIResponse.onSuccess(memberLoyaltyDatas);

                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }

    public void qryMemberRedeemLog(Context context, String memberID, final CallAPIResponse callAPIResponse){
        String apiName = "stamps/members/"+memberID+"/MemberRedeemLog";
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryMemberRedeemLog onStart");
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryMemberRedeemLog onFinish");
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryMemberRedeemLog onFailure msg:" +msg);
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryMemberRedeemLog onSuccess=" + response);
                try {
                    JSONArray data = response.getJSONArray("data");
                    Gson gson = new Gson();
                    MemberLoyaltyData[] memberLoyaltyDatas = new MemberLoyaltyData[data.length()];
                    for(int i=0; i<data.length(); i++){
                        memberLoyaltyDatas[i] = gson.fromJson(data.getString(i),MemberLoyaltyData.class);
                    }
                    if(callAPIResponse != null) callAPIResponse.onSuccess(new MemberLoyaltyData[0]);

                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                    Gson gson = new Gson();
                }
            }
        });
    }

    public void qryMyCoupon(Context context, String memberID, String allotID, final CallAPIResponse callAPIResponse){
        String apiName = "stamps/members/"+memberID+"/coupons/"+allotID;
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryMyCoupon onStart");
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryMyCoupon onFinish");
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryMyCoupon onFailure msg:" +msg);
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryMyCoupon onSuccess=" + response);
                try {
                    String data = response.getString("data");
                    Gson gson = new Gson();
                    MyCouponData myCouponData = gson.fromJson(data,MyCouponData.class);
                    if(callAPIResponse != null) callAPIResponse.onSuccess(myCouponData);

                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }

    public void qryFirmInfo(Context context,String firmID,final CallAPIResponse callAPIResponse){
        String apiName = "stamps/ui/firms/"+firmID;
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryFirmInfo onStart");
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryFirmInfo onFinish");
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryFirmInfo onFailure msg:" +msg);
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryFirmInfo onSuccess=" + response);
                try {
                    String data = response.getString("data");
                    Gson gson = new Gson();
                    FirmInfoData firmInfoData = gson.fromJson(data,FirmInfoData.class);
                    if(callAPIResponse != null) callAPIResponse.onSuccess(firmInfoData);

                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }

    public void qryFrontPageRTN(Context context,String memberID, String device_token, String page,final String userFilter, final CallAPIResponse callAPIResponse) throws UnsupportedEncodingException, JSONException{
        String apiName = "stamps/ui/members/"+memberID+"/"+device_token+"/firmlist?page="+page;
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(VolleyAsyncHttpClient.MATHOD_POST,Env.serviceURL + apiName, jsonObject, userFilter,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryFrontPageRTN onStart");
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryFrontPageRTN onFinish");
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryFrontPageRTN onFailure msg:" +msg);
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryFrontPageRTN onSuccess=" + response);
                try {
                    String data = response.getString("data");
                    Gson gson = new Gson();
                    FrontPageRTNData frontPageRTNData = gson.fromJson(data,FrontPageRTNData.class);
                    if(callAPIResponse != null) callAPIResponse.onSuccess(frontPageRTNData);

                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }

    public void qryMemberPoint(Context context,String memberID, String firmID,final CallAPIResponse callAPIResponse) {
        String apiName = "stamps/ui/members/"+memberID+"/point/"+firmID;
        final JSONObject jsonObject = new JSONObject();
        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryMemberPoint onStart");
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryMemberPoint onFinish");
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryMemberPoint onFailure msg:" +msg);
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryMemberPoint onSuccess=" + response);
                try {
                    JSONArray data = response.getJSONArray("data");
                    Gson gson = new Gson();
                    MemberPointData[] memberPointDatas = new MemberPointData[data.length()];
                    for(int i=0; i<data.length(); i++){
                        memberPointDatas[i] = gson.fromJson(data.getString(i),MemberPointData.class);
                    }
                    if(callAPIResponse != null) callAPIResponse.onSuccess(memberPointDatas);

                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }

    public void qryFirmCoupon(Context context,String memberID, String firmID, String device_token,final CallAPIResponse callAPIResponse) {
        String apiName = "stamps/ui/firm-coupons/"+memberID+"/point/"+firmID+"/"+device_token;
        final JSONObject jsonObject = new JSONObject();
        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryFirmCoupon onStart");
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryFirmCoupon onFinish");
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryFirmCoupon onFailure msg:" +msg);
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryFirmCoupon onSuccess=" + response);
                try {
                    JSONArray data = response.getJSONArray("data");
                    Gson gson = new Gson();
                    MemberCouponsData[] memberCouponsDatas = new MemberCouponsData[data.length()];
                    for(int i=0; i<data.length(); i++){
                        memberCouponsDatas[i] = gson.fromJson(data.getString(i),MemberCouponsData.class);
                    }
                    if(callAPIResponse != null) callAPIResponse.onSuccess(memberCouponsDatas);

                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }

    public void qryCollectibleCoupon(Context context,String memberID, String device_token, String page,final String userfilter,final CallAPIResponse callAPIResponse) throws UnsupportedEncodingException, JSONException{
        String apiName = "stamps/ui/members/"+memberID+"/"+device_token+"/CollectibleCoupon?page="+page;
        final JSONObject jsonObject = new JSONObject();
        VolleyAsyncHttpClient.getInstance(context).post(VolleyAsyncHttpClient.MATHOD_POST,Env.serviceURL + apiName, jsonObject,userfilter,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryFirmCoupon onStart");
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryFirmCoupon onFinish");
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryFirmCoupon onFailure msg:" +msg);
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryFirmCoupon onSuccess=" + response);
                try {
                    String data = response.getString("data");
                    Gson gson = new Gson();
                    DeluxeCoupon deluxeCoupon = gson.fromJson(data,DeluxeCoupon.class);
                    if(callAPIResponse != null) callAPIResponse.onSuccess(deluxeCoupon);

                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }
}
