package friendo.mtel.loyalty.components;

import java.io.Serializable;

/**
 * Created by MTel on 2015/8/6.
 */
public class CollectibleCoupon implements Serializable{
    private String actiontext;
    private String address;
    private String begin_time;
    private int coupon_id;
    private String coupon_rule_type;
    private String description;
    private int distance;
    private String end_time;
    private int firm_id;
    private String firm_name;
    private String firm_picture;
    private String firm_picturepath;
    private String firm_tel;
    private String latitude;
    private String longitude;
    private PeriodData[] period;
    private String picture;
    private String picturepath;
    private int redeem_period;
    private int rem_cnt;
    private int row_nuber;
    private String title;
    private int total_rec;
    private String type;

    public String getActiontext() {
        return actiontext;
    }

    public void setActiontext(String actiontext) {
        this.actiontext = actiontext;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public int getCoupon_id() {
        return coupon_id;
    }

    public void setCoupon_id(int coupon_id) {
        this.coupon_id = coupon_id;
    }

    public String getCoupon_rule_type() {
        return coupon_rule_type;
    }

    public void setCoupon_rule_type(String coupon_rule_type) {
        this.coupon_rule_type = coupon_rule_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
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

    public String getFirm_picture() {
        return firm_picture;
    }

    public void setFirm_picture(String firm_picture) {
        this.firm_picture = firm_picture;
    }

    public String getFirm_picturepath() {
        return firm_picturepath;
    }

    public void setFirm_picturepath(String firm_picturepath) {
        this.firm_picturepath = firm_picturepath;
    }

    public String getFirm_tel() {
        return firm_tel;
    }

    public void setFirm_tel(String firm_tel) {
        this.firm_tel = firm_tel;
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

    public PeriodData[] getPeriod() {
        return period;
    }

    public void setPeriod(PeriodData[] period) {
        this.period = period;
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

    public int getRedeem_period() {
        return redeem_period;
    }

    public void setRedeem_period(int redeem_period) {
        this.redeem_period = redeem_period;
    }

    public int getRem_cnt() {
        return rem_cnt;
    }

    public void setRem_cnt(int rem_cnt) {
        this.rem_cnt = rem_cnt;
    }

    public int getRow_nuber() {
        return row_nuber;
    }

    public void setRow_nuber(int row_nuber) {
        this.row_nuber = row_nuber;
    }

    public int getTotal_rec() {
        return total_rec;
    }

    public void setTotal_rec(int total_rec) {
        this.total_rec = total_rec;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
