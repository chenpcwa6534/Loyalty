package friendo.mtel.loyalty.component;

import java.io.Serializable;

/**
 * Created by MTel on 2015/8/20.
 */
public class FirmListData implements Serializable{
    private int firm_id;
    private String firm_name;
    private String picture;
    private String picturepath;
    private String pointDesc;
    private String description;
    private String firm_tel;
    private int distance;
    private String latitude;
    private String longitude;
    //private String address;
    private int cat_id;
    private String thumbnail;
    private String thumbnailpath;
    private boolean partner;
    private String partner_message;
    private String partener_url;

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

    public String getPointDesc() {
        return pointDesc;
    }

    public void setPointDesc(String pointDesc) {
        this.pointDesc = pointDesc;
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

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnailpath() {
        return thumbnailpath;
    }

    public void setThumbnailpath(String thumbnailpath) {
        this.thumbnailpath = thumbnailpath;
    }

    public boolean isPartner() {
        return partner;
    }

    public void setPartner(boolean partner) {
        this.partner = partner;
    }

    public String getPartner_message() {
        return partner_message;
    }

    public void setPartner_message(String partner_message) {
        this.partner_message = partner_message;
    }

    public String getPartener_url() {
        return partener_url;
    }

    public void setPartener_url(String partener_url) {
        this.partener_url = partener_url;
    }
}
