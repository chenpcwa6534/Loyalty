package friendo.mtel.loyalty.Request;

import android.system.OsConstants;

/**
 * Created by MTel on 2015/8/14.
 */
public class RequestManager {

    public static VerControlRequest setVerControlRequest(String Appver, String OSver, String deviceToken, String deviceModel){
        VerControlRequest verControlRequest = new VerControlRequest();
        verControlRequest.setAppVer(Appver);
        verControlRequest.setOSVer(OSver);
        verControlRequest.setDeviceToken(deviceToken);
        verControlRequest.setDeviceMode(deviceModel);
        return  verControlRequest;
    }
}
