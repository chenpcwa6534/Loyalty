package friendo.mtel.loyalty.data;

import android.content.Context;

import org.json.JSONException;

import friendo.mtel.loyalty.httpsparams.ParamsManager;
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
import friendo.mtel.loyalty.db.DBManager;
import friendo.mtel.loyalty.httpapi.CallAPIResponse;
import friendo.mtel.loyalty.httpapi.HTTPApi;
import friendo.mtel.loyalty.preferences.LoyaltyPreference;

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

    public void qryVersionControl(String verUpdateTime, final GetDataResponse getDataResponse) throws JSONException{
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
                LoyaltyPreference.setAPIRequestTime(mContext, LoyaltyPreference.API.VersionControl,DataCache.cacheVersionControlData.getVer_updatetime());
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
        String userFilter = ParamsManager.getVerControlParams(
                DeviceInformation.getAppVersion(),
                DeviceInformation.getOSVersion(),
                DeviceInformation.getDeviceToken(mContext),
                DeviceInformation.getDeviceModel());
        (new HTTPApi()).qryVersionControl(mContext, Env.getMemberID(mContext), verUpdateTime, userFilter, callAPIResponse);
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
     * @param getDataResponse
     * @return
     */
    public void qryFilter(String verUpdateTime, final GetDataResponse getDataResponse) throws JSONException{

            CallAPIResponse callAPIResponse = new CallAPIResponse() {
                @Override
                public void onStart() {
                    if(getDataResponse != null){
                        getDataResponse.onStart();
                    }
                }

                @Override
                public void onSuccess(Object response) {
                    LoyaltyPreference.setAPIRequestTime(mContext,LoyaltyPreference.API.Filter,((FilterData) response).getUpdateTime());
                    DBManager.setFilterData((FilterData) response);
                    DataCache.cacheFilterData = DBManager.getFilterData();
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


    /**
     * Send Phone number get verifiation code
     * @param userFilter          phone number to Json
     * @param getDataResponse
     */
    public void qryAskOTP( String userFilter, final GetDataResponse getDataResponse){
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
        (new HTTPApi()).qryAskOTP(mContext, userFilter, callAPIResponse);
    }


    /**
     * register
     * @param getDataResponse
     */
    public void qryVerificationOTP(String userFilter , final GetDataResponse getDataResponse){

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
        (new HTTPApi()).qryVerificationOTP(mContext, userFilter, callAPIResponse);
    }


    /**
     *
     * @param getDataResponse
     */
    public void qryAdvertising(boolean isNeedAPI, final GetDataResponse getDataResponse){
        if(DataCache.cacheAdsInfoData == null){
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
    }

    /**
     *
     * @param page              1 page is 0~100 data , 2 page is 101~200 .....
     * @param userFilter        search  params
     * @param getDataResponse
     */
    public void qryFirmList(int page, String userFilter, final GetDataResponse getDataResponse) throws JSONException{

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
            (new HTTPApi()).qryFirmList(mContext, page, userFilter, callAPIResponse);
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
        String userFilter = ParamsManager.getMember(Env.getMemberID(mContext));
        (new HTTPApi()).qryFirmCoupons(mContext, userFilter, firmID, callAPIResponse);
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
            String userFilter = ParamsManager.getMember(Env.getMemberID(mContext));
            (new HTTPApi()).qryFirmPoint(mContext, userFilter, firmID, callAPIResponse);
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
    public void qryLimitCoupons(String userFilter, int page, final GetDataResponse getDataResponse) throws JSONException{

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
        (new HTTPApi()).qryLimitCoupon(mContext, page, userFilter, callAPIResponse);
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
