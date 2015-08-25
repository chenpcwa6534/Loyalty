package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/20.
 */
public class IntentInfoData {
    private String title;
    private String description;
    private String image;
    private String link;
    private String videoURL;
    private int intentType;
    private int catID;
    private int cityID;
    private int subcatID;
    private String subareaID;
    private int orderID;
    private int couponID;
    private int catType;

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public int getIntentType() {
        return intentType;
    }

    public void setIntentType(int intentType) {
        this.intentType = intentType;
    }

    public int getCatID() {
        return catID;
    }

    public void setCatID(int catID) {
        this.catID = catID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public int getSubcatID() {
        return subcatID;
    }

    public void setSubcatID(int subcatID) {
        this.subcatID = subcatID;
    }

    public String getSubareaID() {
        return subareaID;
    }

    public void setSubareaID(String subareaID) {
        this.subareaID = subareaID;
    }

    public int getCouponID() {
        return couponID;
    }

    public void setCouponID(int couponID) {
        this.couponID = couponID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setCatType(int catType) {
        this.catType = catType;
    }

    public int getCatType() {
        return catType;
    }
}
