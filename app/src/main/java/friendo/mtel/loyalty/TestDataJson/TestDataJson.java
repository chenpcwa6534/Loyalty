package friendo.mtel.loyalty.TestDataJson;

import android.util.Log;

import com.astuetz.utility.PicassoUtility;

import org.json.JSONObject;

import friendo.mtel.loyalty.components.Test;

/**
 * Created by MTel on 2015/8/12.
 */
public class TestDataJson {
    private static String TAG = TestDataJson.class.getSimpleName();

    private static  String ResponseError = "{\"result\":false,\"errorCode':301}";

    private static String VersionControl = "{\"result\":true,\"errorCode\":200,\"data\":{\"verUpdateTime\":\"2015/08/01 12:00:00\",\"updateStatus\":true,\"serviceupdate\":true,\"protitle\":{\"name\":\"王大明\",\"birthday\":\"03/05\",\"gender\":\"M\",\"pictrue\":\"http\",\"isModify\":true}}}";
    private static String AskOTPData = "{\"result\":true,\"errorCode\":200}";
    private static String VerificationData = "{\"result\":true,\"errorCode\":200,\"data\":{\"memberID\":1}}";

    public static JSONObject getAskOTPResponseData(){
        return getJsonObject(AskOTPData);
    }

    public static JSONObject getVerificationCodeResponseData(){
        return getJsonObject(VerificationData);
    }

    public static JSONObject getVersionControlResponseData(){
        return getJsonObject(VersionControl);
    }

    public static JSONObject getResponseError(){
        return getJsonObject(ResponseError);
    }

    private static JSONObject getJsonObject(String data){
        JSONObject jsonObject = null;
        try{
            jsonObject = new JSONObject(data);
        }catch (Exception e) {
            Log.e(TAG,"Exception:"+e);
        }
        return jsonObject;
    }
}
