package friendo.mtel.loyalty.data;

import android.content.Context;

import com.google.gson.Gson;

import friendo.mtel.loyalty.Request.RequestManager;
import friendo.mtel.loyalty.Request.VerControlRequest;
import friendo.mtel.loyalty.common.DeviceInformation;
import friendo.mtel.loyalty.common.Env;
import friendo.mtel.loyalty.components.DeluxeCoupon;
import friendo.mtel.loyalty.components.FilterData;
import friendo.mtel.loyalty.components.FirmInfoData;
import friendo.mtel.loyalty.components.FrontPageRTNData;
import friendo.mtel.loyalty.components.MemberCouponsData;
import friendo.mtel.loyalty.components.MemberLoyaltyData;
import friendo.mtel.loyalty.components.MemberPointData;
import friendo.mtel.loyalty.components.MemberRedeemLogData;
import friendo.mtel.loyalty.components.MyCouponData;
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





    //=====================================================//==========================================================================================================
    //  old api


    public FilterData qryFilterData(Context context, boolean isNeedAPI, final GetDataResponse getDataResponse){
        FilterData myFilterData = null;
        if(DataCache.cacheFilterData != null){
            myFilterData = DataCache.cacheFilterData;
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
            (new HTTPApi()).qryFilter(context, callAPIResponse);
        }
        return myFilterData;
    }

    public MemberCouponsData[] qryMemberCouponsData(Context context, boolean isNeedAPI, final GetDataResponse getDataResponse){
        MemberCouponsData[] membersCouponData = null;
        if(DataCache.cacheMemberCouponsData != null){
            membersCouponData = DataCache.cacheMemberCouponsData;
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
                    if(getDataResponse != null){
                        getDataResponse.onSuccess(response);
                    }
                }

                @Override
                public void onSuccess(Object[] response) {
                    DataCache.cacheMemberCouponsData = (MemberCouponsData[]) response;
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
            (new HTTPApi()).qryMemberCoupons(context, Env.getMemberID(context), DeviceInformation.getDeviceToken(), callAPIResponse);
        }
        return membersCouponData;
    }

    public MemberLoyaltyData qryMemberLoyaltyData(Context context,boolean isNeedAPI, final GetDataResponse getDataResponse){
        MemberLoyaltyData memberLoyaltyData = null;
        if(DataCache.cacheMemberLoyaltyData != null){
            memberLoyaltyData = DataCache.cacheMemberLoyaltyData;
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
                    DataCache.cacheMemberLoyaltyData = (MemberLoyaltyData) response;
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
            (new HTTPApi()).qryMemberLoyalty(context, Env.getMemberID(context), callAPIResponse);
        }
        return memberLoyaltyData;
    }

    public MemberRedeemLogData qryMemberRedeemLogDataData(Context context,boolean isNeedAPI, final GetDataResponse getDataResponse){
        MemberRedeemLogData memberRedeemLogData = null;
        if(DataCache.cacheMemberRedeemLogData != null){
            memberRedeemLogData = DataCache.cacheMemberRedeemLogData;
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
                    DataCache.cacheMemberRedeemLogData = (MemberRedeemLogData) response;
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
            (new HTTPApi()).qryMemberRedeemLog(context, Env.getMemberID(context), callAPIResponse);
        }
        return memberRedeemLogData;
    }

    public MyCouponData qryMyCouponData(Context context, String allotID,boolean isNeedAPI, final GetDataResponse getDataResponse){
        MyCouponData myCouponData = null;
        if(DataCache.cacheMyCouponData != null){
            myCouponData = DataCache.cacheMyCouponData;
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
                    DataCache.cacheMyCouponData = (MyCouponData) response;
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
            (new HTTPApi()).qryMyCoupon(context, Env.getMemberID(context), allotID, callAPIResponse);
        }
        return myCouponData;
    }


    public FirmInfoData qryFirmInfoData(Context context, String firmID,boolean isNeedAPI, final GetDataResponse getDataResponse){
        FirmInfoData firmInfoData = null;
        if(DataCache.cacheFirmInfoData != null){
            firmInfoData = DataCache.cacheFirmInfoData;
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
            (new HTTPApi()).qryFirmInfo(context, firmID, callAPIResponse);
        }
        return firmInfoData;
    }



    public FrontPageRTNData qryFrontPageRTNData(Context context, String memberID,String device_token,String page, String userFilter,boolean isNeedAPI, final GetDataResponse getDataResponse){
        FrontPageRTNData frontPageRTNData = null;
        if(DataCache.cacheFrontPageRTNData != null){
            frontPageRTNData = DataCache.cacheFrontPageRTNData;
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
                    DataCache.cacheFrontPageRTNData = (FrontPageRTNData) response;
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
            try {
                (new HTTPApi()).qryFrontPageRTN(context, memberID, device_token, page, userFilter, callAPIResponse);
            }catch (Exception e){

            }
        }
        return frontPageRTNData;
    }

    public MemberPointData[] qryMemberPointData(Context context, String memberID,String firmID,boolean isNeedAPI, final GetDataResponse getDataResponse){
        MemberPointData[] memberPointData = null;
        if(DataCache.cacheMemberPointData != null){
            memberPointData = DataCache.cacheMemberPointData;
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
                    if(getDataResponse != null){
                        getDataResponse.onSuccess(response);
                    }
                }

                @Override
                public void onSuccess(Object[] response) {
                    DataCache.cacheMemberPointData = (MemberPointData[]) response;
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
            try {
                (new HTTPApi()).qryMemberPoint(context, memberID, firmID, callAPIResponse);
            }catch (Exception e){

            }
        }
        return memberPointData;
    }

    public MemberCouponsData[] qryFirmCouponData(Context context, String memberID,String firmID, String device_token ,boolean isNeedAPI, final GetDataResponse getDataResponse){
        MemberCouponsData[] firmCoupon = null;
        if(DataCache.cacheFirmCoupons != null){
            firmCoupon = DataCache.cacheFirmCoupons;
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
                    if(getDataResponse != null){
                        getDataResponse.onSuccess(response);
                    }
                }

                @Override
                public void onSuccess(Object[] response) {
                    DataCache.cacheFirmCoupons = (MemberCouponsData[]) response;
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
            try {
                (new HTTPApi()).qryFirmCoupon(context, memberID, firmID, device_token, callAPIResponse);
            }catch (Exception e){

            }
        }
        return firmCoupon;
    }

    public DeluxeCoupon qryDeluxeCouponData(Context context, String memberID, String device_token, String page,final String userfilter ,boolean isNeedAPI, final GetDataResponse getDataResponse){
        DeluxeCoupon deluxeCoupon = null;
        if(DataCache.cacheDeluxeCoupon != null){
            deluxeCoupon = DataCache.cacheDeluxeCoupon;
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
                    DataCache.cacheDeluxeCoupon = (DeluxeCoupon) response;
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
            try {
                (new HTTPApi()).qryCollectibleCoupon(context, memberID, device_token, page, userfilter,callAPIResponse);
            }catch (Exception e){

            }
        }
        return deluxeCoupon;
    }
}
