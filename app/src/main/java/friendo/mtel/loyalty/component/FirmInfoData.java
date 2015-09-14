package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/21.
 */
public class FirmInfoData {
    private int beacon_id;
    private boolean beacon_status;
    private String address;
    private String firm_tel;
    private String[] business_week;
    private String traffic;
    private String carpark;
    private String[] webUrl;
    private String[] fbUrl;
    private String blogConnnent;


    public int getBeacon_id() {
        return beacon_id;
    }

    public void setBeacon_id(int beacon_id) {
        this.beacon_id = beacon_id;
    }

    public boolean isBeacon_status() {
        return beacon_status;
    }

    public void setBeacon_status(boolean beacon_status) {
        this.beacon_status = beacon_status;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirm_tel() {
        return firm_tel;
    }

    public void setFirm_tel(String firm_tel) {
        this.firm_tel = firm_tel;
    }

    public String[] getBusiness_week() {
        return business_week;
    }

    public void setBusiness_week(String[] business_week) {
        this.business_week = business_week;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getTraffic() {
        return traffic;
    }

    public String getCarpark() {
        return carpark;
    }

    public void setCarpark(String carpark) {
        this.carpark = carpark;
    }

    public String[] getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String[] webUrl) {
        this.webUrl = webUrl;
    }

    public String[] getFbUrl() {
        return fbUrl;
    }

    public void setFbUrl(String[] fbUrl) {
        this.fbUrl = fbUrl;
    }

    public String getBlogConnnent() {
        return blogConnnent;
    }

    public void setBlogConnnent(String blogConnnent) {
        this.blogConnnent = blogConnnent;
    }
}
