package friendo.mtel.loyalty.httpapi;


import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import friendo.mtel.loyalty.httpsparams.MemberParams;
import friendo.mtel.loyalty.httpsparams.RegParams;
import friendo.mtel.loyalty.TestDataJson.TestDataJson;
import friendo.mtel.loyalty.common.Env;
import friendo.mtel.loyalty.component.AdvertisingData;
import friendo.mtel.loyalty.component.CouponDetailData;
import friendo.mtel.loyalty.component.ErrorMessageData;
import friendo.mtel.loyalty.component.FirmCouponsData;
import friendo.mtel.loyalty.component.FirmListData;
import friendo.mtel.loyalty.component.FirmPointData;
import friendo.mtel.loyalty.component.LimitCouponsData;
import friendo.mtel.loyalty.component.MemberCouponsData;
import friendo.mtel.loyalty.component.MemberExChangeData;
import friendo.mtel.loyalty.component.MemberInfoData;
import friendo.mtel.loyalty.component.VerificationData;
import friendo.mtel.loyalty.component.VersionControlData;
import friendo.mtel.loyalty.component.FilterData;
import friendo.mtel.loyalty.component.FirmInfoData;
import friendo.mtel.loyalty.component.MemberPointData;

/**
 * Created by MTel on 2015/7/16.
 */
public class HTTPApi {
    static String TAG = HTTPApi.class.getSimpleName();


    /**
     * 版本相關
     * @param context
     * @param verUpdateTime
     * @param userFilter
     * @param callAPIResponse
     */
    public void qryVersionControl(Context context, String memberID , String verUpdateTime, String userFilter ,final CallAPIResponse callAPIResponse) throws JSONException{
        String apiName = "members/" + memberID + "/VersionControl/";
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("verUpdateTime",verUpdateTime);

        VolleyAsyncHttpClient.getInstance(context).post(VolleyAsyncHttpClient.MATHOD_POST, Env.serviceURL + apiName, jsonObject, userFilter, new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryVersionControl onStart");
                if(callAPIResponse != null){
                    callAPIResponse.onStart();
                }
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryVersionControl onFinish");
                if(callAPIResponse != null){
                    callAPIResponse.onFinish();
                }
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryVersionControl onFailure msg:" +msg);
                if(callAPIResponse != null){
                    callAPIResponse.onFailure(msg);
                }
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryVersionControl onSuccess=" + response);
                try {
                    if(getResult(response)){
                        String data = getData(response);
                        Gson gson = new Gson();
                        VersionControlData versionControlData = gson.fromJson(data,VersionControlData.class);
                        if(callAPIResponse != null) callAPIResponse.onSuccess(versionControlData);
                    }else{
                        String errorMsg = getError(response);
                        if(callAPIResponse != null) callAPIResponse.onFailure(errorMsg);
                    }
                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }


    /**
     * Error Message
     * @param context
     * @param callAPIResponse
     */
    public void qryErrorMessage(Context context, String updateTime ,final CallAPIResponse callAPIResponse){
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
        Log.d(TAG,"ErrorMessage Json : "+ TestDataJson.getErrorMessage().toString());
        if(getResult(TestDataJson.getErrorMessage())){
            String[] data = getArrayData(TestDataJson.getErrorMessage());
            Log.d(TAG,"ErrorMessage api data:" + data);
            Gson gson = new Gson();
            ErrorMessageData[] errorMessageData = new ErrorMessageData[data.length];
            for(int i=0; i<data.length; i++){
                errorMessageData[i] = gson.fromJson(data[i], ErrorMessageData.class);
            }
            if(callAPIResponse != null){
                callAPIResponse.onSuccess(errorMessageData);
            }
        }else{
            if(callAPIResponse != null){
                callAPIResponse.onFailure(getError(context,TestDataJson.getResponseError()));
            }
        }
    }

    /**
     * get list search filter
     * @param context
     * @param updateTime
     * @param callAPIResponse
     */
    public void qryFilter(Context context, String updateTime ,final CallAPIResponse callAPIResponse) throws JSONException{
        String apiName = "stamps/ui/filter";
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("updateTime",updateTime);

        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryFilter onStart");
                if(callAPIResponse != null){
                    callAPIResponse.onStart();
                }
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryFilter onFinish");
                if(callAPIResponse != null){
                    callAPIResponse.onFinish();
                }
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryFilter onFailure msg:" +msg);
                if(callAPIResponse != null){
                    callAPIResponse.onFailure(msg);
                }
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryFilter onSuccess=" + response);
                try {
                    if(getResult(response)){
                        String data = getData(response);
                        Gson gson = new Gson();
                        FilterData filterData = gson.fromJson(data,FilterData.class);
                        if(callAPIResponse != null) callAPIResponse.onSuccess(filterData);
                    }else{
                        String errorMsg = getError(response);
                        if(callAPIResponse != null) callAPIResponse.onSuccess(errorMsg);
                    }
                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }


    /**
     * use phone number get verification code
     * @param context
     * @param userFilter
     * @param callAPIResponse
     */
    public void qryAskOTP(Context context, final String userFilter,final CallAPIResponse callAPIResponse){
        String apiName = "members/AskOTP";
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(VolleyAsyncHttpClient.MATHOD_POST, Env.serviceURL + apiName, jsonObject, userFilter, new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryAskOTP onStart");
                if(callAPIResponse != null){
                    callAPIResponse.onStart();
                }
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryAskOTP onFinish");
                if(callAPIResponse != null){
                    callAPIResponse.onFinish();
                }
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryAskOTP onFailure msg:" +msg);
                if(callAPIResponse != null){
                    callAPIResponse.onFailure(msg);
                }
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryAskOTP onSuccess=" + response);
                try {
                    if(getResult(response)){
                        Gson gson = new Gson();
                        RegParams regParams = gson.fromJson(userFilter, RegParams.class);
                        if(callAPIResponse != null) callAPIResponse.onSuccess(regParams.getCell_no());
                    }
                }catch (Exception e) {
                    Log.e(TAG, "api AskOTP (HTTPApi.class line 254) Exception :" +e.getMessage());
                }
            }
        });
    }


    /**
     * register
     * @param context
     * @param callAPIResponse
     */
    public void qryVerificationOTP(Context context, String userFilter ,final CallAPIResponse callAPIResponse){
        String apiName = "members/mobilelogin/VerificationOTP";
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(VolleyAsyncHttpClient.MATHOD_POST, Env.serviceURL + apiName, jsonObject, userFilter, new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback() {

            @Override
            public void onStart() {
                Log.i(TAG, "qryVerificationOTP onStart");
                if(callAPIResponse != null){
                    callAPIResponse.onStart();
                }
            }

            @Override
            public void onFinish() {
                Log.i(TAG, "qryVerificationOTP onFinish");
                if(callAPIResponse != null){
                    callAPIResponse.onFinish();
                }
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG, "qryVerificationOTP onFailure msg:" + msg);
                if(callAPIResponse != null){
                    callAPIResponse.onFailure(msg);
                }
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryVerificationOTP onSuccess=" + response);
                try {
                    if (getResult(response)) {
                        String data = getData(response);
                        Gson gson = new Gson();
                        VerificationData regRequest = gson.fromJson(data, VerificationData.class);
                        if (callAPIResponse != null) callAPIResponse.onSuccess(regRequest);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "api VerifcationOTP (HTTPApi.class line 297) Exception :" + e.getMessage());
                }
            }
        });
    }


    /**
     * get advertising
     * @param context
     * @param callAPIResponse
     */
    public void qryAdvertising(Context context,final CallAPIResponse callAPIResponse){
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
        Log.d(TAG,"Ads Json : "+ TestDataJson.getAds().toString());
        if(getResult(TestDataJson.getAds())){
            String data = getData(TestDataJson.getAds());
            Log.d(TAG,"Ads Data : "+ data);
            Gson gson = new Gson();
            AdvertisingData advertisingData = gson.fromJson(data, AdvertisingData.class);
            if(callAPIResponse != null){
                callAPIResponse.onSuccess(advertisingData);
            }
        }else{
            if(callAPIResponse != null){
                callAPIResponse.onFailure(getError(context,TestDataJson.getResponseError()));
            }
        }
    }


    /**
     * store list
     * @param context
     * @param page          1 page is 0~100 data , 2 page is 101~200 .....
     * @param userFilter    search  params
     * @param callAPIResponse
     */
    public void qryFirmList(Context context, int page, String userFilter,final CallAPIResponse callAPIResponse) throws JSONException{
        String apiName = "stamps/ui/firmlist?page="+page;
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(VolleyAsyncHttpClient.MATHOD_POST, Env.serviceURL + apiName, jsonObject, userFilter, new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryFirmList onStart");
                if(callAPIResponse != null){
                    callAPIResponse.onStart();
                }
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryFirmList onFinish");
                if(callAPIResponse != null){
                    callAPIResponse.onFinish();
                }
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryFirmList onFailure msg:" +msg);
                if(callAPIResponse != null){
                    callAPIResponse.onFailure(msg);
                }
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryFirmList onSuccess=" + response);
                try {
                    if(getResult(response)){
                        String[] data = getArrayData(response);
                        FirmListData[] firmListDatas = new FirmListData[data.length];
                        Gson gson = new Gson();
                        for(int i=0; i<data.length; i++){
                            firmListDatas[i] = gson.fromJson(data[i],FirmListData.class);
                        }
                        if(callAPIResponse != null) callAPIResponse.onSuccess(firmListDatas);
                    }else{
                        String msg = response.getString("errorMsg");
                        if(callAPIResponse != null) callAPIResponse.onFailure(msg);
                    }
                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }

    /**
     *
     * @param context
     * @param userFilter memberID in JSON
     * @param firmID
     * @param callAPIResponse
     */
    public void qryFirmCoupons(Context context,String userFilter, String firmID,final CallAPIResponse callAPIResponse){
        String apiName = "stamps/ui/firm/" + firmID + "/firm-coupons/";
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(VolleyAsyncHttpClient.MATHOD_POST,Env.serviceURL + apiName, jsonObject, userFilter, new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryFirmCoupons onStart");
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryFirmCoupons onFinish");
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryFirmCoupons onFailure msg:" +msg);
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryFirmCoupons onSuccess=" + response);
                try {
                    if(getResult(response)){
                        String[] data = getArrayData(response);
                        FirmCouponsData[] firmCouponsData = new FirmCouponsData[data.length];
                        Gson gson = new Gson();
                        for(int i=0; i<data.length; i++){
                            firmCouponsData[i] = gson.fromJson(data[i],FirmCouponsData.class);
                        }
                        if(callAPIResponse != null) callAPIResponse.onSuccess(firmCouponsData);
                    }else{
                        String msg = response.getString("errorMsg");
                        if(callAPIResponse != null) callAPIResponse.onFailure(msg);
                    }
                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }


    /**
     *
     * @param context
     * @param operatingType
     * @param memberID
     * @param couponID
     * @param callAPIResponse
     */
    public void qryCouponsDetail(Context context,String operatingType, String memberID, int couponID, final CallAPIResponse callAPIResponse){
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
        Log.d(TAG,"coupins detail Json : "+ TestDataJson.getCouponDetail().toString());
        if(getResult(TestDataJson.getFirmCoupons())){
            String data = getData(TestDataJson.getCouponDetail());
            Gson gson = new Gson();
            CouponDetailData couponDetailDatas = gson.fromJson(data, CouponDetailData.class);
            if(callAPIResponse != null){
                callAPIResponse.onSuccess(couponDetailDatas);
            }
        }else{
            if(callAPIResponse != null){
                callAPIResponse.onFailure(getError(context,TestDataJson.getResponseError()));
            }
        }
    }


    /**
     *
     * @param context
     * @param memberID
     * @param couponID
     * @param useType
     * @param callAPIResponse
     */
    public void qryCouponsControl(Context context, String memberID, int couponID, int useType, final CallAPIResponse callAPIResponse){
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
        Log.d(TAG,"coupon control Json : "+ TestDataJson.getAskOTPResponseData().toString());
        if(getResult(TestDataJson.getAskOTPResponseData())){
            if(callAPIResponse != null){
                callAPIResponse.onSuccess(true);
            }
        }else{
            if(callAPIResponse != null){
                callAPIResponse.onFailure(getError(context,TestDataJson.getResponseError()));
            }
        }
    }


    /**
     *
     * @param context
     * @param userFilter
     * @param firmID
     * @param callAPIResponse
     */
    public void qryFirmPoint(Context context, String userFilter, int firmID, final CallAPIResponse callAPIResponse){
        String apiName = "stamps/ui/firms/" + firmID + "/PointCard";
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(VolleyAsyncHttpClient.MATHOD_POST,Env.serviceURL + apiName, jsonObject, userFilter, new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryFirmPoint onStart");
                if(callAPIResponse != null){
                    callAPIResponse.onStart();
                }
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryFirmPoint onFinish");
                if(callAPIResponse != null){
                    callAPIResponse.onFinish();
                }
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryFirmPoint onFailure msg:" +msg);
                if(callAPIResponse != null){
                    callAPIResponse.onFailure(msg);
                }
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryFirmPoint onSuccess=" + response);
                try {
                    if(getResult(response)){
                        String data = getData(response);
                        Gson gson = new Gson();

                        FirmPointData firmPointData = gson.fromJson(data, FirmPointData.class);
                        if(callAPIResponse != null) callAPIResponse.onSuccess(firmPointData);
                    }
                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }


    /**
     *
     * @param context
     * @param firmID
     * @param callAPIResponse
     */
    public void qryFirmInfo(final Context context, int firmID, final CallAPIResponse callAPIResponse){
        String apiName = "stamps/ui/firms/"+firmID;
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryFirmInfo onStart");
                if(callAPIResponse != null){
                    callAPIResponse.onStart();
                }
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryFirmInfo onFinish");
                if(callAPIResponse != null){
                    callAPIResponse.onFinish();
                }
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryFirmInfo onFailure msg:" +msg);
                if(callAPIResponse != null){
                    callAPIResponse.onFailure(msg);
                }
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryFirmInfo onSuccess=" + response);
                try {
                    if(getResult(response)){
                        String data = getData(response);
                        Gson gson = new Gson();
                        FirmInfoData firmInfoData = gson.fromJson(data,FirmInfoData.class);
                        if(callAPIResponse != null) callAPIResponse.onSuccess(firmInfoData);
                    }else {
                        String msg = getError(response);
                        if(callAPIResponse != null) callAPIResponse.onSuccess(msg);
                    }
                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }


    /**
     *
     * @param context
     * @param pages
     * @param userFilter
     * @param callAPIResponse
     */
    public void qryLimitCoupon(Context context, int pages, String userFilter, final CallAPIResponse callAPIResponse) throws JSONException{
        String apiName = "stamps/ui/CollectibleCoupon?page="+pages;
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(VolleyAsyncHttpClient.MATHOD_POST, Env.serviceURL + apiName, jsonObject, userFilter,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryLimitCoupon onStart");
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryLimitCoupon onFinish");
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryLimitCoupon onFailure msg:" +msg);
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryLimitCoupon onSuccess=" + response);
                try {
                    if(getResult(response)){
                        String[] data = getArrayData(response);
                        LimitCouponsData[] limitCouponsDatas = new LimitCouponsData[data.length];
                        Gson gson = new Gson();
                        for(int i=0; i<data.length; i++){
                            limitCouponsDatas[i] = gson.fromJson(data[i],LimitCouponsData.class);
                        }
                        if(callAPIResponse != null) callAPIResponse.onSuccess(limitCouponsDatas);
                    }else {
                        getError(callAPIResponse,response);
                    }
                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }

    /**
     *
     * @param context
     * @param memberID
     * @param callAPIResponse
     */
    public void qryMemberInfo(Context context, String memberID, final CallAPIResponse callAPIResponse){
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
        Log.d(TAG,"Member information Json : "+ TestDataJson.getMemberInfo().toString());
        if(getResult(TestDataJson.getMemberInfo())){
            String data = getData(TestDataJson.getMemberInfo());
            Gson gson = new Gson();
            MemberInfoData memberInfoData = gson.fromJson(data,MemberInfoData.class);
            if(callAPIResponse != null){
                callAPIResponse.onSuccess(memberInfoData);
            }
        }else{
            if(callAPIResponse != null){
                callAPIResponse.onFailure(getError(context,TestDataJson.getResponseError()));
            }
        }
    }


    /**
     *
     * @param context
     * @param memberID
     * @param callAPIResponse
     */
    public void qryMemberPoint(Context context, final String memberID, final CallAPIResponse callAPIResponse){
        String apiName = "stamps/ui/members/" + memberID + "/mypoint/";
        final JSONObject jsonObject = new JSONObject();

        VolleyAsyncHttpClient.getInstance(context).post(Env.serviceURL + apiName, jsonObject,new VolleyAsyncHttpClient.VolleyAsyncHttpClientCallback(){

            @Override
            public void onStart() {
                Log.i(TAG,"qryMemberPoint onStart");
                if(callAPIResponse != null){
                    callAPIResponse.onStart();
                }
            }

            @Override
            public void onFinish() {
                Log.i(TAG,"qryMemberPoint onFinish");
                if(callAPIResponse != null){
                    callAPIResponse.onFinish();
                }
            }

            @Override
            public void onFailure(String msg) {
                Log.i(TAG,"qryMemberPoint onFailure msg:" +msg);
                if(callAPIResponse != null){
                    callAPIResponse.onFailure(msg);
                }
            }

            @Override
            public void onSuccess(JSONObject response) {
                Log.i(TAG, "qryMemberPoint onSuccess=" + response);
                try {
                    if(getResult(response)){
                        String[] data = getArrayData(response);
                        MemberPointData[] memberPointDatas = new MemberPointData[data.length];
                        Gson gson = new Gson();
                        for (int i=0; i<memberPointDatas.length; i++){
                            memberPointDatas[i] = gson.fromJson(data[i],MemberPointData.class);
                        }
                        if(callAPIResponse != null) callAPIResponse.onSuccess(memberPointDatas);
                    }else{
                        String msg = getError(response);
                        if(callAPIResponse != null) callAPIResponse.onFailure(msg);
                    }
                }catch (Exception e) {
                    Log.e(TAG, e.getMessage());
                }
            }
        });
    }


    /**
     *
     * @param context
     * @param memberID
     * @param callAPIResponse
     */
    public void qryMemberCoupons(Context context, String memberID, final CallAPIResponse callAPIResponse){
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
        Log.d(TAG,"Member coupon Json : "+ TestDataJson.getMemberCoupons().toString());
        if(getResult(TestDataJson.getMemberCoupons())){
            String[] data = getArrayData(TestDataJson.getMemberCoupons());
            Gson gson = new Gson();
            MemberCouponsData[] memberCouponsDatas = new MemberCouponsData[data.length];
            for(int i=0; i<data.length; i++){
                memberCouponsDatas[i] = gson.fromJson(data[i], MemberCouponsData.class);
            }
            if(callAPIResponse != null){
                callAPIResponse.onSuccess(memberCouponsDatas);
            }
        }else{
            if(callAPIResponse != null){
                callAPIResponse.onFailure(getError(context,TestDataJson.getResponseError()));
            }
        }
    }


    /**
     *
     * @param context
     * @param memberID
     * @param page
     * @param callAPIResponse
     */
    public void qryMemberExChange(Context context, String memberID, int page, final CallAPIResponse callAPIResponse){
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
        Log.d(TAG,"Member Exchange Json : "+ TestDataJson.getMemberExChange().toString());
        if(getResult(TestDataJson.getMemberExChange())){
            String[] data = getArrayData(TestDataJson.getMemberExChange());
            Gson gson = new Gson();
            MemberExChangeData[] memberExChangeData = new MemberExChangeData[data.length];
            for(int i=0; i<data.length; i++){
                memberExChangeData[i] = gson.fromJson(data[i], MemberExChangeData.class);
            }
            if(callAPIResponse != null){
                callAPIResponse.onSuccess(memberExChangeData);
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

    private String getError(JSONObject response){
        String errorMsg = "";
        try {
            errorMsg = response.getString("errorMsg");
        }catch (Exception e){
            Log.e(TAG,"ErrorCode have wrong ,JSON to String is fail , data is [" + response.toString()+"]");
        }
        return errorMsg;
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

    private void getError(CallAPIResponse callAPIResponse, JSONObject response){
        String msg = getError(response);
        callAPIResponse.onFailure(msg);
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
}
