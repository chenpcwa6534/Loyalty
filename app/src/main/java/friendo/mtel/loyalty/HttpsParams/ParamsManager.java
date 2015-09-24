package friendo.mtel.loyalty.httpsparams;

import android.content.Context;
import android.location.Location;

import com.astuetz.view.stratch.StratchView;
import com.google.gson.Gson;

import friendo.mtel.loyalty.common.Env;
import friendo.mtel.loyalty.data.DataCache;
import friendo.mtel.loyalty.utility.Utilitys;

/**
 * Created by MTel on 2015/8/3.
 */
public class ParamsManager {
    private static Gson gson = new Gson();

    public static String getMember(String memberid){
        MemberParams memberParams = new MemberParams();
        memberParams.setMember_id(memberid);

        String request = gson.toJson(memberParams);
        return request;
    }

    public static String getFirmListInParams(Context context){
        String result;
        if(DataCache.cacheFrontPageInParams != null){
            result = gson.toJson(DataCache.cacheFrontPageInParams);
        }else{
            DataCache.cacheFrontPageInParams = getParams(context);
            result = gson.toJson(getParams(context));
        }
        return result;
    }

    public static String getFirmListInParams(String latitude, String longitude, String search,int catID, int cityID, int orderID, String subareaID, int subcatID){
        FrontPageInParams frontPageInParams = getFrontPageInParams( latitude,  longitude,  search, catID,  cityID,  orderID,  subareaID,  subcatID);
        DataCache.cacheFrontPageInParams = frontPageInParams;

        return gson.toJson(frontPageInParams);
    }

    public static String getLimitListInParams(Context context){
        String result;
        if(DataCache.cacheFrontPageInParamsLimit != null){
            result = gson.toJson(DataCache.cacheFrontPageInParamsLimit);
        }else {
            FrontPageInParams frontPageInParams = getParams(context);
            frontPageInParams.setMember_id(Env.getMemberID(context));
            DataCache.cacheFrontPageInParamsLimit = frontPageInParams;
            result = gson.toJson(frontPageInParams);
        }
        return result;
    }

    public static String getLimitListInParams(Context context, String latitude, String longitude, String search,int catID, int cityID, int orderID, String subareaID, int subcatID){
        FrontPageInParams frontPageInParams = getFrontPageInParams( latitude,  longitude,  search, catID,  cityID,  orderID,  subareaID,  subcatID);
        frontPageInParams.setMember_id(Env.getMemberID(context));
        DataCache.cacheFrontPageInParamsLimit = frontPageInParams;

        return gson.toJson(frontPageInParams);
    }

    private static FrontPageInParams getParams(Context context){
        Location location = Utilitys.getLocation(context);
        if(Utilitys.isGPS(context) && location != null){
            return ParamsManager.getFrontPageInParams(String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()), "", 0, 0, 1, "", 0);
        }else{
            return ParamsManager.getFrontPageInParams("", "", "", 0, 0, 2, "", 0);
        }
    }

    public static FrontPageInParams getFrontPageInParams(String latitude, String longitude, String search,int catID, int cityID, int orderID, String subareaID, int subcatID){
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

    public static String getVerControlParams(String Appver, String OSver, String deviceToken, String deviceModel){
        VerControlParams verControlParams = new VerControlParams();
        verControlParams.setApp_ver(Appver);
        verControlParams.setOs_ver(OSver);
        verControlParams.setDevice_token(deviceToken);
        verControlParams.setDevice_model(deviceModel);
        verControlParams.setDevice_type(1);
        verControlParams.setChenkno("");
        String request = gson.toJson(verControlParams);
        return request;
    }

    public static String getAskOPTParams(String number){
        RegParams regParams = new RegParams();
        regParams.setCell_no(number);
        String request = gson.toJson(regParams);
        return request;
    }

    public static String getVerificationOTPParams(String number, String verfCode, String token){
        RegParams regParams = new RegParams();
        regParams.setCell_no(number);
        regParams.setDevice_token(token);
        regParams.setVerf_code(verfCode);
        regParams.setDevice_type(1);
        regParams.setCheckno("");
        String request = gson.toJson(regParams);
        return request;
    }
}
