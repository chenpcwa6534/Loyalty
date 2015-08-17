package friendo.mtel.loyalty.data;

import friendo.mtel.loyalty.components.DeluxeCoupon;
import friendo.mtel.loyalty.components.FilterData;
import friendo.mtel.loyalty.components.FirmInfoData;
import friendo.mtel.loyalty.components.FrontPageRTNData;
import friendo.mtel.loyalty.components.MemberCouponsData;
import friendo.mtel.loyalty.components.MemberLoyaltyData;
import friendo.mtel.loyalty.components.MemberPointData;
import friendo.mtel.loyalty.components.MemberRedeemLogData;
import friendo.mtel.loyalty.components.MyCouponData;

/**
 * Created by MTel on 2015/7/17.
 */
public class DataCache {
    public static FilterData cacheFilterData = null;
    public static MemberCouponsData[] cacheMemberCouponsData = null;
    public static MemberLoyaltyData cacheMemberLoyaltyData = null;
    public static MemberRedeemLogData cacheMemberRedeemLogData = null;
    public static MyCouponData cacheMyCouponData = null;
    public static FirmInfoData cacheFirmInfoData = null;
    public static FrontPageRTNData cacheFrontPageRTNData = null;
    public static MemberPointData[] cacheMemberPointData = null;
    public static MemberCouponsData[] cacheFirmCoupons = null;
    public static DeluxeCoupon cacheDeluxeCoupon = null;
}
