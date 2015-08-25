package friendo.mtel.loyalty.data;

import android.content.Context;

import friendo.mtel.loyalty.HttpsParams.FrontPageInParams;
import friendo.mtel.loyalty.HttpsParams.ParamsManager;
import friendo.mtel.loyalty.component.AdvertisingData;
import friendo.mtel.loyalty.component.FirmCouponsData;
import friendo.mtel.loyalty.component.FirmListData;
import friendo.mtel.loyalty.component.FirmPointData;
import friendo.mtel.loyalty.component.LimitCouponsData;
import friendo.mtel.loyalty.component.MemberExChangeData;
import friendo.mtel.loyalty.component.MemberInfoData;
import friendo.mtel.loyalty.component.VersionControlData;
import friendo.mtel.loyalty.components.DeluxeCoupon;
import friendo.mtel.loyalty.component.FilterData;
import friendo.mtel.loyalty.component.FirmInfoData;
import friendo.mtel.loyalty.components.FrontPageRTNData;
import friendo.mtel.loyalty.component.MemberCouponsData;
import friendo.mtel.loyalty.components.MemberLoyaltyData;
import friendo.mtel.loyalty.component.MemberPointData;
import friendo.mtel.loyalty.components.MemberRedeemLogData;
import friendo.mtel.loyalty.components.MyCouponData;

/**
 * Created by MTel on 2015/7/17.
 */
public class DataCache {
    /**
     * =============================Reponse=================================
     */
    public static VersionControlData cacheVersionControlData = null;
    public static FilterData cacheFilterData = null;
    public static AdvertisingData cacheAdsInfoData = null;
    public static FirmListData[] cacheFirmListData = null;
    public static FirmCouponsData[] cacheFirmCouponsDatas = null;
    public static FirmPointData cacheFirmPointData = null;
    public static FirmInfoData cacheFirmInfoData = null;
    public static LimitCouponsData[] cacheLimitCouponsData = null;
    public static MemberInfoData cacheMemberInfoData = null;
    public static MemberPointData[] cacheMemberPointDatas = null;
    public static MemberCouponsData[] cacheMemberCouponsDatas = null;
    public static MemberExChangeData[] cacheMemberExChangeDatas = null;


    /**
     * =============================Request=================================
     */
    public static FrontPageInParams cacheFrontPageInParams;
    public static FrontPageInParams cacheFrontPageInParamsLimit;



    public static void initFrontPageInParams(Context context){
        cacheFrontPageInParams = ParamsManager.getfrontPageInParams(context);
        cacheFrontPageInParamsLimit = ParamsManager.getfrontPageInParams(context);
    }


    //old

    public static MemberCouponsData[] cacheMemberCouponsData = null;
    public static MemberLoyaltyData cacheMemberLoyaltyData = null;
    public static MemberRedeemLogData cacheMemberRedeemLogData = null;
    public static MyCouponData cacheMyCouponData = null;
    public static FrontPageRTNData cacheFrontPageRTNData = null;
    public static MemberPointData[] cacheMemberPointData = null;
    public static MemberCouponsData[] cacheFirmCoupons = null;
    public static DeluxeCoupon cacheDeluxeCoupon = null;


}
