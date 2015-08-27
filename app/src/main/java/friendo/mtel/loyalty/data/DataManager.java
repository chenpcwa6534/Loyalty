package friendo.mtel.loyalty.data;

import android.content.Context;
import com.google.gson.Gson;

import friendo.mtel.loyalty.Request.RequestManager;
import friendo.mtel.loyalty.Request.VerControlRequest;
import friendo.mtel.loyalty.common.DeviceInformation;
import friendo.mtel.loyalty.common.Env;
import friendo.mtel.loyalty.component.AdvertisingData;
import friendo.mtel.loyalty.component.FirmCouponsData;
import friendo.mtel.loyalty.component.FirmListData;
import friendo.mtel.loyalty.component.FirmPointData;
import friendo.mtel.loyalty.component.LimitCouponsData;
import friendo.mtel.loyalty.component.MemberExChangeData;
import friendo.mtel.loyalty.component.MemberInfoData;
import friendo.mtel.loyalty.component.VersionControlData;
import friendo.mtel.loyalty.component.FilterData;
import friendo.mtel.loyalty.component.FirmInfoData;
import friendo.mtel.loyalty.component.MemberCouponsData;
import friendo.mtel.loyalty.component.MemberPointData;
import friendo.mtel.loyalty.httpapi.CallAPIResponse;
import friendo.mtel.loyalty.httpapi.HTTPApi;

/**
 * Created by MTel on 2015/7/17.
 */
public class DataManager {

    private String TAG = DataManager.class.getSimpleName();

    private static DataManager datamanager = null;

    private Context mContext;

    public DataManager(Context context){
        mContext = context;
    }

    public static DataManager getInstance(Context context){
        if(datamanager == null){
            datamanager = new DataManager(context);
        }
        return  datamanager;
    }

    public void qryVersionControl(String verUpdateTime, final GetDataResponse getDataResponse){
        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                DataCache.cacheVersionControlData = (VersionControlData) response;
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        Gson gson = new Gson();
        VerControlRequest verControlRequest = RequestManager.setVerControlRequest(DeviceInformation.getAppVersion(), DeviceInformation.getOSVersion(), DeviceInformation.getDeviceToken(), DeviceInformation.getDeviceModel());
        String body = gson.toJson(verControlRequest);
        (new HTTPApi()).qryVersionControl(mContext, Env.getMemberID(mContext), verUpdateTime, body, callAPIResponse);
    }


    /**
     * get app connection error message
     * @param verUpdateTime
     * @param getDataResponse
     */
    public void qryErrorMessage(String verUpdateTime, final GetDataResponse getDataResponse){
        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryErrorMessage(mContext, verUpdateTime, callAPIResponse);
    }


    /**
     * search condition data
     * @param verUpdateTime
     * @param isNeedAPI
     * @param getDataResponse
     * @return
     */
    public FilterData qryFilter(String verUpdateTime, boolean isNeedAPI, final GetDataResponse getDataResponse){
        FilterData filterData = new FilterData();
        if(DataCache.cacheFilterData != null ){
            filterData = DataCache.cacheFilterData;
        }else{
            isNeedAPI = true;
        }

        if(isNeedAPI){
            CallAPIResponse callAPIResponse = new CallAPIResponse() {
                @Override
                public void onStart() {
                    if(getDataResponse != null){
                        getDataResponse.onStart();
                    }
                }

                @Override
                public void onSuccess(Object response) {
                    DataCache.cacheFilterData = (FilterData) response;
                    if(getDataResponse != null){
                        getDataResponse.onSuccess(response);
                    }
                }

                @Override
                public void onSuccess(Object[] response) {
                    if(getDataResponse != null){
                        getDataResponse.onSuccess(response);
                    }
                }

                @Override
                public void onFailure(Object response) {
                    if(getDataResponse != null){
                        getDataResponse.onFailure(response);
                    }
                }

                @Override
                public void onFinish() {
                    if(getDataResponse != null){
                        getDataResponse.onFinish();
                    }
                }
            };
            (new HTTPApi()).qryFilter(mContext, verUpdateTime, callAPIResponse);
        }
        return filterData;
    }


    /**
     * Send Phone number get verifiation code
     * @param number
     * @param getDataResponse
     */
    public void qryAskOTP( String number, final GetDataResponse getDataResponse){
        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryAskOTP(mContext, number, callAPIResponse);
    }


    /**
     * register
     * @param number
     * @param verificationCode
     * @param deviceToken
     * @param getDataResponse
     */
    public void qryVerificationOTP( String number, String verificationCode, String deviceToken , final GetDataResponse getDataResponse){

        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryVerificationOTP(mContext, number, verificationCode, deviceToken, callAPIResponse);
    }


    /**
     *
     * @param getDataResponse
     */
    public void qryAdvertising(final GetDataResponse getDataResponse){

        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                DataCache.cacheAdsInfoData = (AdvertisingData) response;
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryAdvertising(mContext, callAPIResponse);
    }

    /**
     *
     * @param page              1 page is 0~100 data , 2 page is 101~200 .....
     * @param userFilter        search  params
     * @param getDataResponse
     */
    public void qryFirmList(int page, String userFilter, final GetDataResponse getDataResponse){

        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                DataCache.cacheFirmListData = (FirmListData[]) response;
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryFirmList(mContext, Env.getMemberID(mContext), page, userFilter, callAPIResponse);
    }


    /**
     *
     * @param firmID
     * @param getDataResponse
     */
    public void qryFirmCoupons(String firmID, final GetDataResponse getDataResponse){

        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                DataCache.cacheFirmCouponsDatas = (FirmCouponsData[]) response;
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryFirmCoupons(mContext, Env.getMemberID(mContext), firmID, callAPIResponse);
    }


    /**
     *
     * @param couponID
     * @param getDataResponse
     */
    public void qryCouponDetail(int couponID, final GetDataResponse getDataResponse){

        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryCouponsDetail(mContext, DeviceInformation.Operation, Env.getMemberID(mContext), couponID, callAPIResponse);
    }


    /**
     *
     * @param couponID
     * @param useType
     * @param getDataResponse
     */
    public void qryCouponControl(int couponID, int useType, final GetDataResponse getDataResponse){

        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryCouponsControl(mContext, Env.getMemberID(mContext), couponID, useType, callAPIResponse);
    }


    /**
     *
     * @param firmID
     * @param getDataResponse
     */
    public void qryFirmPoint(int firmID, final GetDataResponse getDataResponse){

        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                DataCache.cacheFirmPointData = (FirmPointData) response;
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryFirmPoint(mContext, Env.getMemberID(mContext), firmID, callAPIResponse);
    }


    /**
     *
     * @param firmID
     * @param getDataResponse
     */
    public void qryFirmInfo(int firmID, final GetDataResponse getDataResponse){

        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                DataCache.cacheFirmInfoData = (FirmInfoData) response;
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryFirmInfo(mContext, firmID, callAPIResponse);
    }


    /**
     *
     * @param userFilter    搜尋條件
     * @param page          頁數 1 :1~100, 2 : 101~200 .....
     * @param getDataResponse
     */
    public void qryLimitCoupons(String userFilter, int page, final GetDataResponse getDataResponse){

        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                DataCache.cacheLimitCouponsData = (LimitCouponsData[]) response;
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryLimitCoupon(mContext, Env.getMemberID(mContext), page, userFilter, callAPIResponse);
    }

    /**
     *
     * @param getDataResponse
     */
    public void qryMemberInfo(final GetDataResponse getDataResponse){

        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                DataCache.cacheMemberInfoData = (MemberInfoData) response;
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryMemberInfo(mContext, Env.getMemberID(mContext), callAPIResponse);
    }


    public void qryMemberPoint(final GetDataResponse getDataResponse){

        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                DataCache.cacheMemberPointDatas = (MemberPointData[]) response;
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryMemberPoint(mContext, Env.getMemberID(mContext), callAPIResponse);
    }

    public void qryMemberCoupons(final GetDataResponse getDataResponse){

        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                DataCache.cacheMemberCouponsDatas = (MemberCouponsData[]) response;
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryMemberCoupons(mContext, Env.getMemberID(mContext), callAPIResponse);
    }


    public void qryMemberExChange(int page, final GetDataResponse getDataResponse){

        CallAPIResponse callAPIResponse = new CallAPIResponse() {
            @Override
            public void onStart() {
                if(getDataResponse != null){
                    getDataResponse.onStart();
                }
            }

            @Override
            public void onSuccess(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onSuccess(Object[] response) {
                DataCache.cacheMemberExChangeDatas = (MemberExChangeData[]) response;
                if(getDataResponse != null){
                    getDataResponse.onSuccess(response);
                }
            }

            @Override
            public void onFailure(Object response) {
                if(getDataResponse != null){
                    getDataResponse.onFailure(response);
                }
            }

            @Override
            public void onFinish() {
                if(getDataResponse != null){
                    getDataResponse.onFinish();
                }
            }
        };
        (new HTTPApi()).qryMemberExChange(mContext, Env.getMemberID(mContext), page, callAPIResponse);
    }
}