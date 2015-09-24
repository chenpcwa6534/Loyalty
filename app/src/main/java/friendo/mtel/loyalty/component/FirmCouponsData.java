package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/20.
 */
public class FirmCouponsData {
    private int coupons_id;
    private String title;
    private String description;
    private String picture;
    private String picturepath;
    private int expireday;
    private boolean type;

    public int getCoupons_id() {
        return coupons_id;
    }

    public void setCoupons_id(int coupons_id) {
        this.coupons_id = coupons_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getExpireday() {
        return expireday;
    }

    public void setExpireday(int expireday) {
        this.expireday = expireday;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
