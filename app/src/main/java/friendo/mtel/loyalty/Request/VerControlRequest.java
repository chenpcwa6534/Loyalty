package friendo.mtel.loyalty.Request;

/**
 * Created by MTel on 2015/8/14.
 */
public class VerControlRequest {

    private String app_ver;
    private String os_ver;
    private String device_token;
    private String device_model;
    private int device_type;
    private String chenkno;

    public String getApp_ver() {
        return app_ver;
    }

    public void setApp_ver(String app_ver) {
        this.app_ver = app_ver;
    }

    public String getOs_ver() {
        return os_ver;
    }

    public void setOs_ver(String os_ver) {
        this.os_ver = os_ver;
    }

    public String getDevice_token() {
        return device_token;
    }

    public void setDevice_token(String device_token) {
        this.device_token = device_token;
    }

    public String getDevice_model() {
        return device_model;
    }

    public void setDevice_model(String device_model) {
        this.device_model = device_model;
    }

    public int getDevice_type() {
        return device_type;
    }

    public void setDevice_type(int device_type) {
        this.device_type = device_type;
    }

    public String getChenkno() {
        return chenkno;
    }

    public void setChenkno(String chenkno) {
        this.chenkno = chenkno;
    }
}
