package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/24.
 */
public class LimitCouponsData {

    private int cat_id;
    private int coupons_id;
    private String description;
    private int expireday;
    private int firm_id;
    private String firm_name;
    private String picture;
    private String picturepath;
    private int rem_cnt;
    private String title;

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public int getCoupons_id() {
        return coupons_id;
    }

    public void setCoupons_id(int coupons_id) {
        this.coupons_id = coupons_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExpireday() {
        return expireday;
    }

    public void setExpireday(int expireday) {
        this.expireday = expireday;
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

    public int getRem_cnt() {
        return rem_cnt;
    }

    public void setRem_cnt(int rem_cnt) {
        this.rem_cnt = rem_cnt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
