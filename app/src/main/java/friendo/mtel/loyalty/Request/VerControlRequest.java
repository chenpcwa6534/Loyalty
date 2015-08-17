package friendo.mtel.loyalty.Request;

/**
 * Created by MTel on 2015/8/14.
 */
public class VerControlRequest {

    private String AppVer;
    private String OSVer;
    private String deviceToken;
    private String deviceMode;
    private int OperationType;
    private String verUpdateTime;

    public String getAppVer() {
        return AppVer;
    }

    public void setAppVer(String appVer) {
        AppVer = appVer;
    }

    public String getOSVer() {
        return OSVer;
    }

    public void setOSVer(String OSVer) {
        this.OSVer = OSVer;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDeviceMode() {
        return deviceMode;
    }

    public void setDeviceMode(String deviceMode) {
        this.deviceMode = deviceMode;
    }

    public int getOperationType() {
        return OperationType;
    }

    public void setOperationType(int operationType) {
        OperationType = operationType;
    }

    public String getVerUpdateTime() {
        return verUpdateTime;
    }

    public void setVerUpdateTime(String verUpdateTime) {
        this.verUpdateTime = verUpdateTime;
    }
}
