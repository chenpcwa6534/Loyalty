package friendo.mtel.loyalty.Request;

/**
 * Created by MTel on 2015/8/14.
 */
public class RegRequest {
    
    private String number;
    private String verificationCode;
    private String deviceToken;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
