package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/24.
 */
public class LimitCouponsData {

    private String name;
    private String title;
    private String desc;
    private int catID;
    private int expireday;
    private int count;
    private String picture;
    private int couponID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public int getExpireday() {
        return expireday;
    }

    public void setExpireday(int expireday) {
        this.expireday = expireday;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCouponID() {
        return couponID;
    }

    public void setCouponID(int couponID) {
        this.couponID = couponID;
    }
}
