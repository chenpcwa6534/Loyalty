package friendo.mtel.loyalty.Request;

import com.google.gson.Gson;

/**
 * Created by MTel on 2015/8/14.
 */
public class RequestManager {
    private static Gson gson = new Gson();

    public static VerControlRequest setVerControlRequest(String Appver, String OSver, String deviceToken, String deviceModel){
        VerControlRequest verControlRequest = new VerControlRequest();
        verControlRequest.setApp_ver(Appver);
        verControlRequest.setOs_ver(OSver);
        verControlRequest.setDevice_token(deviceToken);
        verControlRequest.setDevice_model(deviceModel);
        verControlRequest.setDevice_type(1);
        verControlRequest.setChenkno("");
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
