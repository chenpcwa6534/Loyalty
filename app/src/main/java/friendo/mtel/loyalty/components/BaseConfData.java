package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/7/29.
 */
public class BaseConfData {
    private String address;
    private String latitude;
    private String longitude;
    private String official_site;
    private String parking;
    private RecommendedSitesData recommended_site;
    private String tel;
    private String traffic;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOfficial_site() {
        return official_site;
    }

    public void setOfficial_site(String official_site) {
        this.official_site = official_site;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public RecommendedSitesData getRecommended_site() {
        return recommended_site;
    }

    public void setRecommended_site(RecommendedSitesData recommended_site) {
        this.recommended_site = recommended_site;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }
}
