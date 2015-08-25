package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/21.
 */
public class FirmInfoData {
    private int beaconID;
    private String description;
    private String address;
    private String number;
    private String[] businessWeek;
    private String traffic;
    private String carpark;
    private String[] webUrl;
    private String blogConnnent;

    public int getBeaconID() {
        return beaconID;
    }

    public void setBeaconID(int beaconID) {
        this.beaconID = beaconID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String[] getBusinessWeek() {
        return businessWeek;
    }

    public void setBusinessWeek(String[] businessWeek) {
        this.businessWeek = businessWeek;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
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

    public String getBlogConnnent() {
        return blogConnnent;
    }

    public void setBlogConnnent(String blogConnnent) {
        this.blogConnnent = blogConnnent;
    }
}
