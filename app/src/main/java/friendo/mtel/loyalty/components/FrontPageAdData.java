package friendo.mtel.loyalty.components;

/**
 * Created by MTel on 2015/8/3.
 */
public class FrontPageAdData {
    private int ads_id;
    private String desc;
    private int location;
    //private RawMessageData location_data;
    private String picture;
    private String picturepaht;

    public int getAds_id() {
        return ads_id;
    }

    public void setAds_id(int ads_id) {
        this.ads_id = ads_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

//    public RawMessageData getLocation_data() {
//        return location_data;
//    }
//
//    public void setLocation_data(RawMessageData location_data) {
//        this.location_data = location_data;
//    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicturepaht() {
        return picturepaht;
    }

    public void setPicturepaht(String picturepaht) {
        this.picturepaht = picturepaht;
    }
}
