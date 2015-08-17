package friendo.mtel.loyalty.components;

import java.io.Serializable;

/**
 * Created by MTel on 2015/7/30.
 */
public class FirmInfoData implements Serializable{
    private String address;
    private BaseConfData base_conf;
    private BeaconsData[] beacons;
    private PeriodData[] business_time;
    private String description;
    private int firm_id;
    private String firm_name;
    private String latitude;
    private String longitude;
    private String official_site;
    private String openhours_remark;
    private String parking;
    private String picture;
    private String picturepath;
    private String promote_info;
    private RecommendedSitesData recommended_site;
    private String tel;
    private String traffic;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BaseConfData getBase_conf() {
        return base_conf;
    }

    public void setBase_conf(BaseConfData base_conf) {
        this.base_conf = base_conf;
    }

    public BeaconsData[] getBeacons() {
        return beacons;
    }

    public void setBeacons(BeaconsData[] beacons) {
        this.beacons = beacons;
    }

    public PeriodData[] getBusiness_time() {
        return business_time;
    }

    public void setBusiness_time(PeriodData[] business_time) {
        this.business_time = business_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFirm_id() {
        return firm_id;
    }

    public void setFirm_id(int firm_id) {
        this.firm_id = firm_id;
    }

    public String getFirm_name() {
        return firm_name;
    }

    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
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

    public String getOpenhours_remark() {
        return openhours_remark;
    }

    public void setOpenhours_remark(String openhours_remark) {
        this.openhours_remark = openhours_remark;
    }

    public String getParking() {
        return parking;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicturepath() {
        return picturepath;
    }

    public void setPicturepath(String picturepath) {
        this.picturepath = picturepath;
    }

    public String getPromote_info() {
        return promote_info;
    }

    public void setPromote_info(String promote_info) {
        this.promote_info = promote_info;
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
