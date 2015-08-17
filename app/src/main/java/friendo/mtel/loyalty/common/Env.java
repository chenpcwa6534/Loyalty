package friendo.mtel.loyalty.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;

import friendo.mtel.loyalty.components.MemberCouponsData;
import friendo.mtel.loyalty.components.Test;
import friendo.mtel.loyalty.preferences.LoyaltyPreference;

/**
 * Created by MTel on 2015/7/16.
 */
public class Env {
    private static String TAG = Env.class.getSimpleName();

    public static String serviceURL = "http://lb-singularity-661822449.ap-northeast-1.elb.amazonaws.com:80/v1/";

    public static String ApiKEY = "Authorization";
    public static String ApiValue = "X2ZyaWVuZG9fbWVtYmVyX2NhcmRf";

    /** Device Information **/
    private static String MemberID = "";

    public static String getMemberID(Context context){
        //return "62a714dd-987d-46ec-80f3-a14072a21ed1";
        if(MemberID.equals("")){
            MemberID = LoyaltyPreference.getMemberID(context);
        }
        return MemberID;
    }




}
