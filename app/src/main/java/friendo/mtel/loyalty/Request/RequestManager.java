package friendo.mtel.loyalty.Request;

import com.google.gson.Gson;

/**
 * Created by MTel on 2015/8/14.
 */
public class RequestManager {
    private static Gson gson = new Gson();

    public static VerControlRequest setVerControlRequest(String Appver, String OSver, String deviceToken, String deviceModel){
        VerControlRequest verControlRequest = new VerControlRequest();
        verControlRequest.setAppVer(Appver);
        verControlRequest.setOSVer(OSver);
        verControlRequest.setDeviceToken(deviceToken);
        verControlRequest.setDeviceMode(deviceModel);
        return  verControlRequest;
    }

    public static String setAskOPTResquest(String number){
        RegRequest regRequest = new RegRequest();
        regRequest.setCell_no(number);
        String request = gson.toJson(regRequest);
        return request;
    }

    public static String setVerificationOTPRequese(String number, String verfCode ,String token){
        RegRequest regRequest = new RegRequest();
        regRequest.setCell_no(number);
        regRequest.setDevice_token(token);
        regRequest.setVerf_code(verfCode);
        regRequest.setDevice_type(1);
        regRequest.setCheckno("");
        String request = gson.toJson(regRequest);
        return request;
    }
}
