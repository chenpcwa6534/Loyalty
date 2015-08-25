package friendo.mtel.loyalty.HttpsParams;

import android.content.Context;
import android.location.Location;

import friendo.mtel.loyalty.utility.Utilitys;

/**
 * Created by MTel on 2015/8/3.
 */
public class ParamsManager {

    public static FrontPageInParams getfrontPageInParams(Context context){
//        FrontPageInParams frontPageInParams ;
//        if(Utilitys.isGPS(context)){
//            Location location = Utilitys.getLocation(context);
//            frontPageInParams = ParamsManager.getfrontPageInParams(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()), "", 0, 0, 1, "", 0);
//        }else{
//            frontPageInParams = ParamsManager.getfrontPageInParams("", "", "", 0, 0, 2, "", 0);
//        }
        FrontPageInParams frontPageInParams = ParamsManager.getfrontPageInParams("", "", "", 0, 0, 2, "", 0);
        return frontPageInParams;
    }

    public static FrontPageInParams getfrontPageInParams(String latitude, String longitude, String search,int catID, int cityID, int orderID, String subareaID, int subcatID){
        FrontPageInParams frontPageInParams = new FrontPageInParams();
        frontPageInParams.setLatitude(latitude);
        frontPageInParams.setLongitude(longitude);
        frontPageInParams.setSearch(search);

        UserFilterParams userFilterResponse = new UserFilterParams();
        userFilterResponse.setCat_id(catID);
        userFilterResponse.setCity_id(cityID);
        userFilterResponse.setOrder_id(orderID);
        userFilterResponse.setSubarea_id(subareaID);
        userFilterResponse.setSubcat_id(subcatID);

        frontPageInParams.setUserfilter(userFilterResponse);
        return frontPageInParams;
    }

    public static CouponAllotParams getcouponAllotParams(int allotID,boolean allotStauts, int couponsID, String device_token){
        CouponAllotParams couponAllotParams = new CouponAllotParams();
        couponAllotParams.setAllot_id(allotID);
        couponAllotParams.setAllot_status(allotStauts);
        couponAllotParams.setCoupons_id(couponsID);
        couponAllotParams.setDevice_token(device_token);

        return couponAllotParams;
    }
}
