package friendo.mtel.loyalty.component;

/**
 * Created by MTel on 2015/8/20.
 */
public class CouponDetailData {
    private String title;
    private String description;
    private String available;
    private String picture;
    private String picturePath;
    private int cancellationType;
    private int showType;
    private int cancellationStatus;
    private boolean isConvert;
    private boolean isCollect;
    private String notic;
    private StoreInfoData storeInfo;

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

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public int getCancellationType() {
        return cancellationType;
    }

    public void setCancellationType(int cancellationType) {
        this.cancellationType = cancellationType;
    }

    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }

    public int getCancellationStatus() {
        return cancellationStatus;
    }

    public void setCancellationStatus(int cancellationStatus) {
        this.cancellationStatus = cancellationStatus;
    }

    public boolean isConvert() {
        return isConvert;
    }

    public void setIsConvert(boolean isConvert) {
        this.isConvert = isConvert;
    }

    public boolean isCollect() {
        return isCollect;
    }

    public void setIsCollect(boolean isCollect) {
        this.isCollect = isCollect;
    }

    public String getNotic() {
        return notic;
    }

    public void setNotic(String notic) {
        this.notic = notic;
    }

    public StoreInfoData getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(StoreInfoData storeInfo) {
        this.storeInfo = storeInfo;
    }
}
