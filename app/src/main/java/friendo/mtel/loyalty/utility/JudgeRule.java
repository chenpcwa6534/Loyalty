package friendo.mtel.loyalty.utility;

import android.content.Context;

import friendo.mtel.loyalty.R;

/**
 * Created by MTel on 2015/8/6.
 */
public class JudgeRule {

    public static String getCouponType(Context context,String couponCode){
        if(couponCode.equals("fb_share")){
            return context.getResources().getString(R.string.strApi_fbShare);
        }else if(couponCode.equals("1st")){
            return context.getResources().getString(R.string.strApi_1st);
        }else if(couponCode.equals("latest")){
            return context.getResources().getString(R.string.strApi_latest);
        }
        return "";
    }
}
