package friendo.mtel.loyalty.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.util.Log;

import friendo.mtel.loyalty.preferences.LoyaltyPreference;

/**
 * Created by MTel on 2015/8/14.
 */
public class DeviceInformation {
    private static String TAG = DeviceInformation.class.getSimpleName();

    private static String DeviceToken = "";
    private static String AppVersion = "";
    private static String OSVersion = "";
    private static String DeviceModel = "";
    public static String Operation = "1";

    public static String getDeviceToken(Context context){
        String token = LoyaltyPreference.getDeviceToken(context);
        return DeviceToken;
    }

    public static String getAppVersion(){
        try{
            if(AppVersion.equals("")){
                PackageInfo packageInfo = new PackageInfo();
                AppVersion = String.valueOf(packageInfo.versionCode);
            }
        }catch (Exception e){
            Log.e(TAG, "get Applcation version is wrong, debug is DeviceInformation.class 22 line,  Exception :" + e);
        }
        return AppVersion;
    }

    public static String getOSVersion(){
        try{
            if(OSVersion.equals("")){
                OSVersion = Build.MANUFACTURER + " " + Build.MODEL;
            }
        }catch (Exception e){
            Log.e(TAG,"get android SDK version is wrong, debug is DeviceInformation.class 34 line, Exception :" + e);
        }
        return OSVersion;
    }

    public static String getDeviceModel(){
        try{
            if(DeviceModel.equals("")){
                DeviceModel = String.valueOf(Build.VERSION.SDK_INT);
            }
        }catch (Exception e){
            Log.e(TAG,"get device model is wrong, debug is DeviceInformation.class 45 line, Exception :" + e);
        }
        return DeviceModel;
    }
}
